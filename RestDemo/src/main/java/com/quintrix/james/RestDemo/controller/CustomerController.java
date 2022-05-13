package com.quintrix.james.RestDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.james.RestDemo.models.customer.Customer;
import com.quintrix.james.RestDemo.restservice.CustomerService;

@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	Customer getCustomerById(@PathVariable("id") Long id) {

		logger.debug("Request: Called getCustomerById Controller {}", id);
		return customerService.getCustomerById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	List<Customer> getCustomerList() {

		return customerService.getCustomers();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	Customer addCustomer(@RequestBody Customer customer) {

		return customerService.addCustomer(customer);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable("id") Long id) {

		customerService.deleteCustomerById(id);
	}
}
