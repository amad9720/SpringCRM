package com.webapp.aopdemo.dao;

import com.webapp.aopdemo.Account;
import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Component
public class MembershipDAO {
    public void addSilly() {
        System.out.println(MembershipDAO.class + " Adding menbership");
    }

    public String addBooba(Account account) {
        System.out.println(MembershipDAO.class + " Adding menbership for " + account.getName() );
        return account.getName();
    }
}
