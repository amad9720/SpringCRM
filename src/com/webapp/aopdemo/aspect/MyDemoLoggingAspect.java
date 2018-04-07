package com.webapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
public class MyDemoLoggingAspect {
    // This is where we add all of our related advices for logging
    // Let's start with an @Before advice

//    Let's use pointcut declaration : re-use a pointcut expression in multiple advises without copy paste
//          --> Easily reuse the pointcuts
//          --> Update pointcut in one location
//          --> Share and combine pointcup expressions
    @Pointcut("execution(* add*(..))")
    public void addMethodsPointcuts() {}

    @Pointcut("execution(* get*(..))")
    public void getter() {}

    @Pointcut("execution(* set*(..))")
    public void setter() {}

    //    Combining pointcuts
    @Pointcut("addMethodsPointcuts() && !(getter() || setter())")
    public void forAddNoGetterSetter() {}

    @Before("addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void beforeAddAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount");
    }

    @Before("addMethodsPointcuts()") //any method starting with add and having one arg of any type
    public void apiAnalytics() {
        System.out.print("\n=======>>> Executing @Before the Analytics for the API");
    }

    @Before("forAddNoGetterSetter()") //any method starting with add and having one arg of any type
    public void NoGetterSetter() {
        System.out.print("\n=======>>> Executing @Before add method that not a getter or setter");
    }



//    Previous version before the use of pointcute declaration

//    @Before("execution(public void add*())") //any method of public void starting with add
//    @Before("execution(void add*())") //any method of void starting with add
//    @Before("execution(* add*())") //any method starting with add
//    @Before("execution(String add*())") //any method of String starting with add
//    @Before("execution(* add*(..))") //any method starting with add and having 0 or more args
//    @Before("execution(* add*(*))") //any method starting with add and having one arg of any type
//    @Before("execution(* com.webapp.aopdemo.dao.*.*())") //any method starting with add and having one arg of any type
//    @Before("execution(* com.webapp.aopdemo.dao.*.*(..))") //any method starting with add in our package
//    @Before("execution(* add*(com.webapp.aopdemo.Account))") //any method starting with add and having one arg of any type
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=======>>> Executing @Before advice on addAccount");
//    }
}
