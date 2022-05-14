package com.quintrix.james.restdemo.models;

import java.util.List;
import com.quintrix.james.restdemo.models.agent.Agent;



public class GetEmployeeResponse {

  private String availableEmployee;

  private List<Agent> agentsList;

  List<ClientEmployee> availableEmployeeList;

  // Getters and Setters
  public String getAvailableEmployee() {
    return availableEmployee;
  }

  public List<Agent> getAgentsList() {
    return agentsList;
  }

  public void setAgentsList(List<Agent> agentsList) {
    this.agentsList = agentsList;
  }

  public void setAvailableEmployee(String availableEmployee) {
    this.availableEmployee = availableEmployee;
  }

  public List<ClientEmployee> getAvailableEmployeeList() {
    return availableEmployeeList;
  }

  public void setAvailableEmployeeList(List<ClientEmployee> availableEmployeeList) {
    this.availableEmployeeList = availableEmployeeList;
  }

}
