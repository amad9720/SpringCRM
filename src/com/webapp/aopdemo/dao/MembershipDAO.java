package com.webapp.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * Created by owner on 18-04-07.
 */
@Component
public class MembershipDAO {
    public void addSilly() {
        System.out.println(MembershipDAO.class + " Adding menbership");
    }

    public void addBooba() {
        System.out.println(MembershipDAO.class + " Adding menbership for Booba");
    }
}
