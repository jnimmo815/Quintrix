package com.quintrix.jfs.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quintrix.jfs.customer.documents.Customer;
import com.quintrix.jfs.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RestTemplate restTemplate; 	
	
	
	@Value("${agentService.getUr2}")
	String agentServiceGetUr2;

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

	@Override
	public Customer getCustomerById(Long id) {
		
		Iterable<Customer> cust = customerRepository.findAll();
		List<Customer> customerList = Streamable.of(cust).toList();		
		
		Optional<Customer> customer = customerList.stream().filter(c -> c.getId().equals(id)).findAny();		
		
		return customer.get();		
		
	}

	
}
