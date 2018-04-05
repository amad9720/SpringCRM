package com.webapp.service;

import com.webapp.entity.Customer;

import java.util.List;

/**
 * Created by owner on 18-04-04.
 */
public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomers(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
