package com.quintrix.james.JPADemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quintrix.james.JPADemo.entity.Employee;
import com.quintrix.james.JPADemo.models.GetEmployeeResponse;
import com.quintrix.james.JPADemo.service.EmployeeService;
import com.quintrix.james.JPADemo.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	GetEmployeeResponse getEmployees(@RequestParam(name = "lastName", required = false) String lastName) {

		return employeeService.getEmployee(lastName);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employees/{id}")
	Employee getCarDetails(@PathVariable("id") Integer id) {

		return employeeService.getEmployeeById(id);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	Employee addCars(@RequestBody Employee employee) {

		return employeeService.addEmployee(employee);
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
	}
}