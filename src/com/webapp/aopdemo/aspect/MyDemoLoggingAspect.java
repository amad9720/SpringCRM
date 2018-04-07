package com.webapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.webapp.aopdemo.aspect.AopExpressionsDeclaration.addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void beforeAddAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount");
    }





}
