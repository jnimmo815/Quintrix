package com.quintrix.james.restdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.james.restdemo.entity.Employee;
import com.quintrix.james.restdemo.models.GetEmployeeResponse;
import com.quintrix.james.restdemo.service.EmployeeService;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping(method = RequestMethod.GET, value = "/employees")
  GetEmployeeResponse getEmployees(
      @RequestParam(name = "lastName", required = false) String lastName) {

    return employeeService.getEmployee(lastName);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
  Employee getEmployeerDetails(@PathVariable("id") Integer id) {

    return employeeService.getEmployeeById(id);

  }

  @RequestMapping(method = RequestMethod.POST, value = "/employees")
  Employee addEmployee(@RequestBody Employee employee) {

    return employeeService.addEmployee(employee);
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Integer id) {
    employeeService.deleteEmployeeById(id);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/employees/all")
  GetEmployeeResponse getAllEmployees() {

    return employeeService.getAllEmployees();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/employees")
  Employee updateEmployee(@RequestBody Employee employee) {

    return employeeService.updateEmployee(employee);
  }

}
