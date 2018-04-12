package com.webapp.aopdemo;

import com.webapp.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by owner on 18-04-07.
 */
public class MainDemoAroundAOPApp {
    public static void main(String[] args) {
        // Read the java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        // Call the business method
        System.out.println("Main App : for the @Around");
        System.out.println("Calling get fortune");

        String data = fortuneService.getFortune();

        System.out.println("Call finished");
        System.out.println("the data :" + data);

        // Close the context
        context.close();
    }
}
