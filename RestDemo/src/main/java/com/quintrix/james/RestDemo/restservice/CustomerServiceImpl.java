package com.quintrix.james.RestDemo.restservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.quintrix.james.RestDemo.exception.CustomerNotFoundException;
import com.quintrix.james.RestDemo.models.customer.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${agentService.getCustomerUrl}")
	String getCustomerUrl;

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = null;

		ResponseEntity<List<Customer>> customerListResponseEntity = restTemplate.exchange(getCustomerUrl,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {
				});

		if (customerListResponseEntity.getStatusCode() == HttpStatus.OK) {
			customerList = customerListResponseEntity.getBody();
		}

		return customerList;
	}

	@Override
	public Customer getCustomerById(Long id) {

		try {

			ResponseEntity<Customer> customer = restTemplate.exchange(getCustomerUrl + "/" + id, HttpMethod.GET, null,
					Customer.class);
			return customer.getBody();

		} catch (Exception ex) {

			logger.debug("How can this happen? Why is the agent calling customer with id = {}", id);
			throw new CustomerNotFoundException("Invalid Id", "Please use a different Id");
		}

	}

	@Override
	public Customer addCustomer(Customer customer) {

		ResponseEntity<Customer> customertResponseEntity = restTemplate.exchange(getCustomerUrl, HttpMethod.POST, null,
				Customer.class);

		return customertResponseEntity.getBody();

	}

	@Override
	public void deleteCustomerById(Long id) {

		restTemplate.exchange(getCustomerUrl + "/" + id, HttpMethod.DELETE, null, Customer.class);

	}

}
