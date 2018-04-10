package com.webapp.aopdemo.aspect;

import com.webapp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "com.webapp.aopdemo.aspect.AopExpressionsDeclaration.findMathodPointcuts()",
            returning = "result"
    )
    public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result) {

        System.out.println("\n=======>>> Executing @AfterReturning advice on findAccounts");

        // let's test for the argument tht is passed to the monitored function
        System.out.println("Checking the aspect joinPoint : " + joinPoint.getArgs()[0]);

        // Let's get the returned data from the monitored function
        for (Account theAccount :
             result) {
            System.out.println(theAccount.toString());
        }

        // Let's intercept and modify the from the monitored function before it's returned in the actual function (findAccounts)
        // Post-process and modify
        ConvertAccountNameToUpperCase(result);
    }

    private void ConvertAccountNameToUpperCase(List<Account> result) {
        for (Account theAccount:
                result) {
            theAccount.setName(theAccount.getName().toUpperCase());
        }
    }

    @Before("com.webapp.aopdemo.aspect.AopExpressionsDeclaration.addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void beforeAddAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount");
    }





}
