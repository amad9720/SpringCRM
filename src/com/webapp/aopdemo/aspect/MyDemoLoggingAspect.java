package com.webapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging
    // Let's start with an @Before advice

    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount");
    }
}
