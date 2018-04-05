package com.webapp.service;

import com.webapp.dao.CustomerDAO;
import com.webapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by owner on 18-04-04.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomers(Customer theCustomer) {
        customerDAO.saveCustomers(theCustomer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Transactional
    @Override
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }
}
