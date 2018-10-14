package com.wyc.api.aspect;

import com.alibaba.fastjson.JSONObject;
import com.wyc.annotation.Date;
import com.wyc.annotation.Range;
import com.wyc.annotation.Require;
import com.wyc.annotation.Valid;
import com.wyc.api.base.BaseResp;
import com.wyc.enums.ResponseCode;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;

/**
 * @author: wyc
 * @date: 2018/10/11
 */
@Aspect
@Component
public class ParamsValidateAspect {


    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ss", "fdsaf");
        System.out.println(jsonObject.getInteger("sfds"));
    }

    @Around(value = "execution(* com.wyc.api.controller.*.*(..))")
    public BaseResp paramsValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());

        //获取形参
        Parameter[] parameters = realMethod.getParameters();

        //获取实参
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return (BaseResp) joinPoint.proceed();
        }
        //由于所有参数都封装在实体类中，因此只需要校验第一个实参即可，此处转化为json对象，方便下面处理
        String json = JSONObject.toJSONString(args[0]);
        JSONObject jsonObject = JSONObject.parseObject(json);

        BaseResp resp;
        for (Parameter parameter : parameters) {
            //只对添加了校验注解的参数进行校验
            if (parameter.isAnnotationPresent(Valid.class)) {
                Field[] fields = parameter.getType().getDeclaredFields();
                for (Field field : fields) {
                    //校验必填(Require)注解
                    resp = verifyRequire(jsonObject, field);
                    if (resp != null) {
                        return resp;
                    }

                    //校验值范围（Range）注解
                    resp = verifyRange(jsonObject, field);
                    if (resp != null) {
                        return resp;
                    }

                    resp = verifyDate(jsonObject, field);
                    if (resp != null) {
                        return resp;
                    }
                }
            }
        }
        resp = (BaseResp) joinPoint.proceed();

        return resp;
    }

    private BaseResp verifyDate(JSONObject jsonObject, Field field) {
        if (field.isAnnotationPresent(Date.class)) {
            BaseResp resp = new BaseResp();
            Date date = field.getAnnotation(Date.class);
            String fieldName = field.getName();
            String value = jsonObject.getString(fieldName);
            String[] betweenValue = date.between();
            String biggerThan = date.biggerThan();
            String lessThan = date.lessThan();
            String biggerAndEqualThan = date.biggerAndEqualThan();
            String lessAndEqualThan = date.lessAndEqualThan();
            String pattern = date.pattern();
            String equal = date.equal();
            String message = date.message();
            String defaultPattern = "yyyy-MM-dd HH:mm:ss";
            if (StringUtils.isNotBlank(pattern)) {

                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                try {
                    dateFormat.parse(value);
                    defaultPattern = pattern;
                } catch (Exception e) {
                    resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                    resp.setMsg(message);
                    return resp;
                }
            }
            if (StringUtils.isNotBlank(equal)) {
                if (!StringUtils.equals(value, equal)) {
                    resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                    resp.setMsg(message);
                    return resp;
                }
            }

            java.util.Date inputTime = null;
            try {
                inputTime = DateUtils.parseDate(value, new String[]{defaultPattern});

                if (betweenValue.length == 2) {
                    java.util.Date startTime = DateUtils.parseDate(betweenValue[0], new String[]{defaultPattern});
                    java.util.Date endTime = DateUtils.parseDate(betweenValue[1], new String[]{defaultPattern});
                    if (startTime.compareTo(inputTime) <= 0 && endTime.compareTo(inputTime) >= 0) {

                    } else {
                        resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                        resp.setMsg(message);
                        return resp;
                    }
                }

                if (StringUtils.isNotBlank(biggerAndEqualThan)) {
                    java.util.Date biggerAndEqualThanTime = DateUtils.parseDate(biggerAndEqualThan, new String[]{defaultPattern});
                    if (biggerAndEqualThanTime.compareTo(inputTime) > 0) {
                        resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                        resp.setMsg(message);
                        return resp;
                    }
                }

                if (StringUtils.isNotBlank(biggerThan)) {
                    java.util.Date biggerThanTime = DateUtils.parseDate(biggerThan, new String[]{defaultPattern});
                    if (biggerThanTime.compareTo(inputTime) <= 0) {
                        resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                        resp.setMsg(message);
                        return resp;
                    }
                }

                if (StringUtils.isNotBlank(lessAndEqualThan)) {
                    java.util.Date lessAndEqualThanTime = DateUtils.parseDate(lessAndEqualThan, new String[]{defaultPattern});
                    if (lessAndEqualThanTime.compareTo(inputTime) < 0) {
                        resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                        resp.setMsg(message);
                        return resp;
                    }
                }

                if (StringUtils.isNotBlank(lessThan)) {
                    java.util.Date lessThanTime = DateUtils.parseDate(lessThan, new String[]{defaultPattern});
                    if (lessThanTime.compareTo(inputTime) >= 0) {
                        resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                        resp.setMsg(message);
                        return resp;
                    }
                }

                if (StringUtils.isNotBlank(equal)) {
                    java.util.Date equalTime = DateUtils.parseDate(equal, new String[]{defaultPattern});
                    if (equalTime.compareTo(inputTime) != 0) {
                        resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                        resp.setMsg(message);
                        return resp;
                    }
                }
            } catch (Exception e) {
                resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                resp.setMsg(message);
                return resp;
            }

        }
        return null;
    }

    private BaseResp verifyRange(JSONObject jsonObject, Field field) {
        if (field.isAnnotationPresent(Range.class)) {
            Range range = field.getAnnotation(Range.class);
            boolean pass = false;
            BaseResp resp = new BaseResp();
            String fieldName = field.getName();
            String message = range.message();
            int[] intValues = range.intValue();
            float[] floatValues = range.floatValue();
            double[] doubleValues = range.doubleValue();
            String[] stringValues = range.stringValue();
            if (intValues.length > 0) {
                Integer value = jsonObject.getInteger(fieldName);
                if (value != null) {
                    for (int intValue : intValues) {
                        if (value.equals(intValue)) {
                            pass = true;
                            break;
                        }
                    }
                }
            }
            if (floatValues.length > 0) {
                Float value = jsonObject.getFloat(fieldName);
                if (value != null) {
                    for (float floatValue : floatValues) {
                        if (value.equals(floatValue)) {
                            pass = true;
                            break;
                        }
                    }
                }
            }
            if (doubleValues.length > 0) {
                Double value = jsonObject.getDouble(fieldName);
                if (value != null) {
                    for (double doubleValue : doubleValues) {
                        if (value.equals(doubleValue)) {
                            pass = true;
                            break;
                        }
                    }
                }
            }
            if (stringValues.length > 0) {
                String value = jsonObject.getString(fieldName);
                for (String stringValue : stringValues) {
                    if (StringUtils.equals(value, stringValue)) {
                        pass = true;
                        break;
                    }
                }
            }
            if (!pass) {
                resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                resp.setMsg(message);
                return resp;
            }
        }
        return null;
    }

    private BaseResp verifyRequire(JSONObject jsonObject, Field field) {
        BaseResp resp = new BaseResp();
        if (field.isAnnotationPresent(Require.class)) {
            Require require = field.getAnnotation(Require.class);
            String message = require.message();
            String fieldName = field.getName();
            if (jsonObject.get(fieldName) == null) {
                resp.setCode(ResponseCode.ERROR_PARAMS.getCode());
                resp.setMsg(ResponseCode.ERROR_PARAMS.getMsg());
                return resp;
            }

        }
        return null;
    }
}
