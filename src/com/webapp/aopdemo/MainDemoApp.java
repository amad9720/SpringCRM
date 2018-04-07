package com.webapp.aopdemo;

import com.webapp.aopdemo.dao.AccountDAO;
import com.webapp.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by owner on 18-04-07.
 */
public class MainDemoApp {
    public static void main(String[] args) {
        // Read the java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // Call the business method
        theAccountDAO.addAccount();
        theMembershipDAO.addBooba();

        // Close the context
        context.close();
    }
}
