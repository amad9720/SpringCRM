package com.webapp.dao;

import com.webapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by owner on 18-04-01.
 */

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    //  Need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //  @Transactional  -> we will remove it here since we added a service which will delegate the DAO and manage the transaction (see in CustomerService)
    public List<Customer> getCustomers() {
        // get the hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        // execute query ans get the result list
        List<Customer> customers = theQuery.getResultList();

        // return the result
        return customers;
    }
}
