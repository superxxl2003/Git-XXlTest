package com.xxlspringboot.usermanage.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Before(value = "execution(* com.xxlspringboot.usermanage.controller.*.*(..))")
    public void beforeAdvice (JoinPoint joinPoint) {
        logger.info("Before without args");
    }

    @Before(value = "execution(* com.xxlspringboot.usermanage.controller.*.*(..)) && args(object)")
    public void beforeAdvice (JoinPoint joinPoint, Object object) {
        logger.info("Before with args: " + object.toString());
    }

    @After(value = "execution(* com.xxlspringboot.usermanage.controller.*.*(..)) && args(object)")
    public void afterAdvice (JoinPoint joinPoint, Object object) {
        logger.info("After with args: " + object.toString());
    }

    @AfterReturning(value = "execution(* com.xxlspringboot.usermanage.controller.*.*(..)) && args(object)", returning = "returningObject")
    public void afterAdvice (JoinPoint joinPoint, Object object, Object returningObject) {
        logger.info("After returning with args: " + object.toString() + " and returning: " + returningObject.toString());
    }
}
