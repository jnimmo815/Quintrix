package com.quintrix.jfs.customer.service;

import java.util.List;


import com.quintrix.jfs.customer.documents.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public Customer addCustomer(Customer customer);
	
	public  Customer  getCustomerById(Long id);
	
}
