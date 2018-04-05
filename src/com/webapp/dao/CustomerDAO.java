package com.webapp.dao;

import com.webapp.entity.Customer;

import java.util.List;

/**
 * Created by owner on 18-04-01.
 */
public interface CustomerDAO {
    public List<Customer> getCustomers();
    void saveCustomers(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
