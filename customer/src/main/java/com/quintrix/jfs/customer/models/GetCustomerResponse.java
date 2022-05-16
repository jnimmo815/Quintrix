package com.quintrix.jfs.customer.models;

import java.util.List;

public class GetCustomerResponse {

  private String availableCustomers;

  private List<ClientCustomer> availableCustomersList;

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

  // List<Agent> agentsList;



}
