package com.quintrix.james.restdemo.models;

public class ClientEmployee {

  private String firstName;

  private String lastName;

  public ClientEmployee() {}

  public ClientEmployee(String firstName, String lastName) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Getters and Setters
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
