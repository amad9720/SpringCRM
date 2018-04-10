package com.webapp.aopdemo.aspect_before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Aspect
@Component
@Order(3)
public class MyDemoCloudAspect {

    @Before("com.webapp.aopdemo.aspect_before.AopExpressionsDeclaration.forAddNoGetterSetter()") //any method starting with add and having one arg of any type
    public void NoGetterSetter() {
        System.out.println("\n=======>>> Executing @Before add method that not a getter or setter");
    }

}
