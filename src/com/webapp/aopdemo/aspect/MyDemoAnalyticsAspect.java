package com.webapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
@Order(2)
public class MyDemoAnalyticsAspect {

    @Pointcut("execution(* add*(..))")
    public void addMethodsPointcuts() {}

    @Before("addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void apiAnalytics() {
        System.out.println("\n=======>>> Executing @Before the Analytics for the API");
    }


}
