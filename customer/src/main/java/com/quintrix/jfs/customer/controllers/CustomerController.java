package com.quintrix.jfs.customer.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.jfs.customer.documents.Customer;
import com.quintrix.jfs.customer.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/customer")
    List<Customer> getCustomers(@RequestParam(name = "name", required = false) String make) {    	    	
    	
		return customerService.getAllCustomers();   	    	
    }	
		
    	
	@RequestMapping(method = RequestMethod.POST, value = "/customer")
    Customer addCustomer(@RequestBody Customer customer) {   
    	
    	return customerService.addCustomer(customer);    	
    }
}
