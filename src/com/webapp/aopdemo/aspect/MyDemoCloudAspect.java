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
@Order(3)
public class MyDemoCloudAspect {

    @Pointcut("execution(* add*(..))")
    public void addMethodsPointcuts() {}

    @Pointcut("execution(* get*(..))")
    public void getter() {}

    @Pointcut("execution(* set*(..))")
    public void setter() {}

    //    Combining pointcuts
    @Pointcut("addMethodsPointcuts() && !(getter() || setter())")
    public void forAddNoGetterSetter() {}

    @Before("forAddNoGetterSetter()") //any method starting with add and having one arg of any type
    public void NoGetterSetter() {
        System.out.println("\n=======>>> Executing @Before add method that not a getter or setter");
    }

}
