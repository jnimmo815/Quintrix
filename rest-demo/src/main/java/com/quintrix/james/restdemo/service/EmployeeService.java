package com.quintrix.james.restdemo.service;

import com.quintrix.james.restdemo.entity.Employee;
import com.quintrix.james.restdemo.models.GetEmployeeResponse;

public interface EmployeeService {


  Employee addEmployee(Employee employee);

  Employee updateEmployee(Employee employee);

  void deleteEmployeeById(Integer id);

  Employee getEmployeeById(Integer id);

  GetEmployeeResponse getEmployee(String lastName);

  GetEmployeeResponse getAllEmployees();

}
