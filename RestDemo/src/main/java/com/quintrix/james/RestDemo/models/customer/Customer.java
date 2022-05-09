package com.quintrix.james.RestDemo.models.customer;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Customer {
    
	@Id
	private Long id;
	
	private String name;
	
	private String phone;
	
	private Integer age;
	
	private Boolean active;
	
	private String state;

	public Customer() {};
	
	public Customer(Long id, String name, String phone, Integer age, Boolean active, String state) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.active = active;
		this.state = state;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Customer {id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", active=" + active
				+ ", state=" + state + "}";
	}

	// toString
	
	
	
}