package com.webapp.controller;

import com.webapp.entity.Customer;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by owner on 18-04-01.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
//    we are not using the DAO directly anymore because it's delegated by the service customer (it's a more flexible pattern )
//    @Autowired
//    private CustomerDAO customerDAO;

//  Let's inject the customer service instead since it delegate the CustomerDAO
    @Autowired
    private CustomerService customerService;

//  @RequestMapping("/list") this map all kind of requests
//  This one map only Get requests
    @GetMapping("/list")
    public String listCustomers(Model theModel) {

//        // get the list of students from the DAO (Data Access Object) helper
//        We will use the customer service instead
//        List<Customer> customerList = customerDAO.getCustomers();

// get the list of students from the DAO (Data Access Object) helper by using the customer service
        List<Customer> customerList = customerService.getCustomers();


        // set it as an attribute inside the Model
        theModel.addAttribute("customers", customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // We create a new customer to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer using our service
        customerService.saveCustomers(theCustomer);

        return "redirect:/customer/list";
    }
}
