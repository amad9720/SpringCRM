package com.webapp.aopdemo.aspect_before;

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
}
