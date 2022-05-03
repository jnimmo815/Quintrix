package com.quintrix.jfs.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintrix.jfs.customer.documents.Customer;
import com.quintrix.jfs.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> custList = customerRepository.findAll();
		
		return custList;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		Customer createdCustomer = customerRepository.insert(customer);
		
		return createdCustomer;
	}

	
}
