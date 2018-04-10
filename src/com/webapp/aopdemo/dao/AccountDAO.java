package com.webapp.aopdemo.dao;

import com.webapp.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 18-04-07.
 */
@Component
public class AccountDAO {

    public void addAccount(Account account) {
        System.out.println(getClass() + " Creating a new account for " + account.getName());
    }

    public List<Account> findAccount(String stringTestJoinPoint) {
        List<Account> myAccounts = new ArrayList<>();

        Account account1 = new Account("Amadou", "Helba");
        Account account2 = new Account("Selou", "kabala");
        Account account3 = new Account("Ousmane", "Permon");
        Account account4 = new Account("Selanka", "nermo");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);
        myAccounts.add(account4);

        return myAccounts;
    }
}
