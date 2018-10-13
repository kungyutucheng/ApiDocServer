package com.wyc.api.aspect;

import com.alibaba.fastjson.JSONObject;
import com.wyc.annotation.Require;
import com.wyc.annotation.Valid;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wyc
 * @date: 2018/10/11
 */
@Aspect
@Component
public class ParamsValidateAspect {


    @Around(value = "execution(* com.wyc.api.controller.*.*(..))")
    public Map<String, Object> paramsValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());

        //获取形参
        Parameter[] parameters = realMethod.getParameters();

        //获取实参
        Object[] args = joinPoint.getArgs();
        Map<String, Object> resultMap = new HashMap<>();
        for (Parameter parameter : parameters) {
            //只对添加了校验注解的参数进行校验
            if (parameter.isAnnotationPresent(Valid.class)) {
                Field[] fields = parameter.getType().getDeclaredFields();
                for (Field field : fields) {
                    //只对添加了校验注解的属性进行校验
                    if (field.isAnnotationPresent(Require.class)) {
                        Require require = field.getAnnotation(Require.class);
                        String message = require.message();
                        boolean isParamExist = true;
                        for (Object arg : args) {
                            String json = JSONObject.toJSONString(arg);
                            JSONObject jsonObject = JSONObject.parseObject(json);
                            String fieldName = field.getName();
                            if (jsonObject.get(fieldName) == null) {
                                isParamExist = false;
                            }

                        }
                        if (!isParamExist) {
                            resultMap.put("code", -1);
                            resultMap.put("msg", message);
                            return resultMap;
                        }
                    }
                }
            }
        }
        resultMap = (Map<String, Object>) joinPoint.proceed();

        return resultMap;
    }
}
