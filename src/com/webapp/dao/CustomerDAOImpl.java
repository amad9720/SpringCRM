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
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // execute query ans get the result list then return the result
        return theQuery.getResultList();
    }

    @Override
    public void saveCustomers(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        // This line of code save or update an entry according of it's disponibility
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        // Get the customer from the DB and delete him
        currentSession.delete(getCustomer(theId));

        // Here is another method to do the same thing
//        Query theQuery = currentSession.createQuery("delete from Customer as c where c.id=:theId");
//        theQuery.setParameter("theId", theId);
//
//        theQuery.executeUpdate();
    }
}
