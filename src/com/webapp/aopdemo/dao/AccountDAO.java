package com.webapp.aopdemo.dao;

import com.webapp.aopdemo.Account;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Component
public class AccountDAO {

    public void addAccount(Account account) {
        System.out.println(getClass() + " Creating a new account for " + account.getName());
    }
}
