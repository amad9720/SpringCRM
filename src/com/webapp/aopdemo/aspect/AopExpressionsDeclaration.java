package com.webapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by owner on 18-04-08.
 */
public class AopExpressionsDeclaration {
    @Pointcut("execution(* add*(..))")
    public void addMethodsPointcuts() {}

    @Pointcut("execution(* get*(..))")
    public void getter() {}

    @Pointcut("execution(* set*(..))")
    public void setter() {}

    //    Combining pointcuts
    @Pointcut("addMethodsPointcuts() && !(getter() || setter())")
    public void forAddNoGetterSetter() {}

    //Pointcuts for @AfterReturning / @AfterThrowing and @After advises
    @Pointcut("execution(* find*(String))")
    public void findMathodPointcuts(){}

    //Pointcuts for @Around advises
    @Pointcut("execution(* com.webapp.aopdemo.service.TrafficFortuneService.get*())")
    public void getFortuneMathodPointcuts(){}
}
