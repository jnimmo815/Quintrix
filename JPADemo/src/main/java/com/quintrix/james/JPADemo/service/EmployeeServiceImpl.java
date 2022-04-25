package com.quintrix.james.JPADemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quintrix.james.JPADemo.entity.Employee;
import com.quintrix.james.JPADemo.models.ClientEmployee;
import com.quintrix.james.JPADemo.models.GetEmployeeResponse;
import com.quintrix.james.JPADemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee(1, "John", "Smith"),  new Employee(1, "Tom", "Jones")));

	@Override
	public Employee getEmployeeById(Integer id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if (employee.isPresent()) {
    		return employee.get();
    	} else {
    		return new Employee();
    	}
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee createdEmployee = employeeRepository.save(employee);
		
		return createdEmployee;
	}

	@Override
	public GetEmployeeResponse getEmployee(String lastName) {
		
		GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();
		
		if (lastName != null) {
    		getEmployeeResponse.setAvailableEmployeeList(employeeList.stream().filter(e -> e.getLastName().equals(lastName))
    				.map(e -> new ClientEmployee(e.getFirstName(), e.getLastName())).collect(Collectors.toList()));
		}
		
		getEmployeeResponse.setAvailableEmployee("Available");
		
		return getEmployeeResponse;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		
		employeeRepository.deleteById(id);
	}

	
	

}
