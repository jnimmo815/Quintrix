package com.quintrix.james.restdemo.restservice;

import java.util.List;
import com.quintrix.james.restdemo.models.customer.Customer;
import com.quintrix.james.restdemo.models.customer.GetCustomerResponse;

public interface CustomerService {

  public List<Customer> getCustomersList();

  public Customer getCustomerById(Long id);

  public Customer addCustomer(Customer customer);

  public void deleteCustomerById(Long id);

  public GetCustomerResponse getCostomers(String name);
}
