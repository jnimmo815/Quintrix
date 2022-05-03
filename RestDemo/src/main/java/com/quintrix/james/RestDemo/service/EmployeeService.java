package com.quintrix.james.RestDemo.service;

import com.quintrix.james.RestDemo.entity.Employee;
import com.quintrix.james.RestDemo.models.GetEmployeeResponse;

public interface EmployeeService {
	

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Integer id);

	Employee getEmployeeById(Integer id);

	GetEmployeeResponse getEmployee(String lastName);

	GetEmployeeResponse getAllEmployees();

}
