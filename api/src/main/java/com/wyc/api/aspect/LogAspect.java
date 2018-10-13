package com.wyc.api.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut(value = "execution(* com.wyc.api.controller.*.*(..))")
    public void logPoint() {
    }

    @Before(value = "logPoint()")
    public void before(JoinPoint joinPoint) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(
                "类名【"
                        + joinPoint.getTarget().getClass().getSimpleName()
                        + "】，方法【"
                        + joinPoint.getSignature().getName()
                        + "】，入参："
                        + JSONObject.toJSONString(joinPoint.getArgs()));

    }

    @AfterReturning(value = "logPoint()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(
                "类名【"
                        + joinPoint.getTarget().getClass().getSimpleName()
                        + "】，方法【"
                        + joinPoint.getSignature().getName()
                        + "】，出参："
                        + JSONObject.toJSONString(returnValue));
    }
}
