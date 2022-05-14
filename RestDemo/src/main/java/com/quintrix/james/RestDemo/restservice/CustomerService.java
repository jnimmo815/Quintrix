package com.quintrix.james.restdemo.restservice;

import java.util.List;
import com.quintrix.james.restdemo.models.customer.Customer;

public interface CustomerService {

  public List<Customer> getCustomers();

  public Customer getCustomerById(Long id);

  public Customer addCustomer(Customer customer);

  public void deleteCustomerById(Long id);

}
