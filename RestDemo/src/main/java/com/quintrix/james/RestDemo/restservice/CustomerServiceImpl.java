package com.quintrix.james.RestDemo.restservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.james.RestDemo.models.customer.Customer;

import aj.org.objectweb.asm.TypeReference;

@Component
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	RestTemplate restTemplate; 
	
	@Value("${agentService.getCustomerUrl}")
	String getCustomerUrl;

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = null;
		
		ResponseEntity<List<Customer>> customerListResponseEntity = restTemplate.exchange(getCustomerUrl,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});
		
		if (customerListResponseEntity.getStatusCode() == HttpStatus.OK) {
			customerList = customerListResponseEntity.getBody();				
		}		
		
		return customerList;
	}

	@Override
	public Customer getCustomerById(Long id) {
				
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);	
				
		ResponseEntity<Customer> customer = restTemplate.exchange(getCustomerUrl, HttpMethod.GET, null, Customer.class, params);	
						
		return customer.getBody();
		
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		ResponseEntity<Customer> customertResponseEntity = restTemplate.exchange(getCustomerUrl,
				HttpMethod.POST, null , Customer.class); 		
					
		return customertResponseEntity.getBody();	
		
	}

	@Override
	public void deleteCustomerById(Long id) {
							
			Map<String, Long> params = new HashMap <String, Long> ();		
			
			 params.put("id", id);
			 
			 RestTemplate restTemplate = new RestTemplate();
			 
			 restTemplate.delete(getCustomerUrl, params);		
		
	}

}
