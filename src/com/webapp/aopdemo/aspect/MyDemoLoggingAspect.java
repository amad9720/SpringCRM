package com.webapp.aopdemo.aspect;

import com.webapp.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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


    @Around("com.webapp.aopdemo.aspect.AopExpressionsDeclaration.getFortuneMathodPointcuts()")
    public Object aroundFortuneService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\n=======>>> Executing @Around advice on " + proceedingJoinPoint.getSignature());

        long begin = System.currentTimeMillis();

//        Here we are executing the method of the advise (getFortune)
        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        long duration = end - begin;

        System.out.println(duration/1000.0 + " SECONDS");

        return result;
    }

    // Alway execute (even there is an exeption in the function) it's like the finally block in a try catch
    @After("com.webapp.aopdemo.aspect.AopExpressionsDeclaration.findMathodPointcuts()")
    public void afterFinalyFindAccounts(JoinPoint joinPoint) {

        System.out.println("\n=======>>> Executing @AfterFinaly advice on findAccounts");

        // let's test for the argument tht is passed to the monitored function
        System.out.println("Checking the aspect joinPoint : " + joinPoint.getArgs()[0]);

    }

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

    //    @AfterThrowing(
//            pointcut = "com.webapp.aopdemo.aspect.AopExpressionsDeclaration.findMathodPointcuts()",
//            throwing = "theException"
//    )
//    public void afterReturningFindAccounts(JoinPoint joinPoint, Exception theException) {
//
//        System.out.println("\n=======>>> Executing @AfterThrowing advice on findAccounts");
//
//    }

    @Before("com.webapp.aopdemo.aspect.AopExpressionsDeclaration.addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void beforeAddAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount");
    }





}
