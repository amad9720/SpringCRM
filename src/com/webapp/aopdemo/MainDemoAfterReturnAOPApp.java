package com.webapp.aopdemo;

import com.webapp.aopdemo.dao.AccountDAO;
import com.webapp.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by owner on 18-04-07.
 */
public class MainDemoAfterReturnAOPApp {
    public static void main(String[] args) {
        // Read the java config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


        // Call the business method
        List<Account> accountList = theAccountDAO.findAccount("The Join point is working");

        for (Account theAccount:
                accountList) {
            System.out.println(theAccount.getName());
        }

        // Close the context
        context.close();
    }
}
