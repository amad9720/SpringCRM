package com.webapp.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " Creating a new account");
    }
}
