package com.webapp.controller;

import com.webapp.dao.CustomerDAO;
import com.webapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by owner on 18-04-01.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        // get the list of students fro the DAO (Data Access Object) helper
        List<Customer> customerList = customerDAO.getCustomers();

        // set it as an attribute inside the Model
        theModel.addAttribute("customers", customerList);

        return "list-customers";
    }
}
