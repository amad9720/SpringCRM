package com.webapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by owner on 18-04-12.
 */
@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.webapp.controller.*.*(..))")
    private void forControllerPackage(){};

    @Pointcut("execution(* com.webapp.service.*.*(..))")
    private void forServicePackage(){};

    @Pointcut("execution(* com.webapp.dao.*.*(..))")
    private void forDAOPackage(){};

    @Pointcut("forControllerPackage() || forDAOPackage() || forServicePackage()")
    private void forAppFlow(){};

    @Before("forAppFlow")
    public void before(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toString();
        logger.info("====> in @Before: Calling the method " + theMethod);
    }
}
