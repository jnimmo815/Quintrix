package com.quintrix.james.restdemo.models.customer;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agent;

public class GetCustomerResponse {

  private String availableCustomers;

  private List<ClientCustomer> availableCustomersList;

  List<Agent> agentsList;

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

  public List<Agent> getAgentsList() {
    return agentsList;
  }

  public void setAgentsList(List<Agent> agentsList) {
    this.agentsList = agentsList;
  }


}
