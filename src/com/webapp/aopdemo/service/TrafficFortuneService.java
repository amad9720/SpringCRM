package com.webapp.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by owner on 18-04-11.
 */
@Component
public class TrafficFortuneService implements FortuneService {
    @Override
    public String getFortune() {

//        Simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Expect an heavy traffic today";
    }
}
