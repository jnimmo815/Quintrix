package com.quintrix.james.RestDemo.restservice;

import java.util.List;

import com.quintrix.james.RestDemo.models.customer.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(Long id);
	
	public Customer addCustomer(Customer customer);
	
	public void deleteCustomerById(Long id);

}
