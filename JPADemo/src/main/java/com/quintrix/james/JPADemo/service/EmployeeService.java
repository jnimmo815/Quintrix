package com.quintrix.james.JPADemo.service;

import java.util.List;

import com.quintrix.james.JPADemo.entity.Employee;
import com.quintrix.james.JPADemo.models.GetEmployeeResponse;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	void deleteEmployeeById(Integer id);

	Employee getEmployeeById(Integer id);

	GetEmployeeResponse getEmployee(String lastName);

	// List<GetEmployeeResponse> getAllEmployees();

}
