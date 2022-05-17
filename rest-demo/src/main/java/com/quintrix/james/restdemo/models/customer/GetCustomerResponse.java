package com.quintrix.james.restdemo.models.customer;

import java.util.List;

public class GetCustomerResponse {

  private String availableCustomers;

  private List<ClientCustomer> availableCustomersList;

  // List<Agent> agentsList;

  // Getters and Setters
  public String getAvailableCustomers() {
    return availableCustomers;
  }

  public void setAvailableCustomers(String availableCustomers) {
    this.availableCustomers = availableCustomers;
  }

  public List<ClientCustomer> getAvailableCustomersList() {
    return availableCustomersList;
  }

  public void setAvailableCustomersList(List<ClientCustomer> availableCustomersList) {
    this.availableCustomersList = availableCustomersList;
  }


}
