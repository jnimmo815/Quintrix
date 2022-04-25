package com.quintrix.james.JPADemo.models;

import java.util.List;

public class GetEmployeeResponse {
	
	private String availableEmployee;
	
	List<ClientEmployee> availableEmployeeList;

	// Getters and Setters
	public String getAvailableEmployee() {
		return availableEmployee;
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
