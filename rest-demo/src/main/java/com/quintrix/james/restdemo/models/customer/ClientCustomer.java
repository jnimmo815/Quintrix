package com.quintrix.james.restdemo.models.customer;

public class ClientCustomer {

  private String name;

  private String phone;

  private Integer age;

  private Boolean active;

  private String state;

  // Getters and Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }



}
