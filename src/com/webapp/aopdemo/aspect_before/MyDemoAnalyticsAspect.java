package com.webapp.aopdemo.aspect_before;

import com.webapp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
@Order(2)
public class MyDemoAnalyticsAspect {

    @Before("com.webapp.aopdemo.aspect_before.AopExpressionsDeclaration.addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void apiAnalytics(JoinPoint joinPoint) {
        // Get the arguments of the method which is intercepted by this advise

//        if (joinPoint instanceof Account) {

            Account account = (Account) joinPoint.getArgs()[0];
            System.out.println("\n=======>>> Executing @Before the Analytics for " + account.getName() + " password : " + account.getPassword());
//        }

    }

}
