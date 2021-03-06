package com.quintrix.james.JPADemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.quintrix.james.JPADemo.entity.Employee;
import com.quintrix.james.JPADemo.models.ClientEmployee;
import com.quintrix.james.JPADemo.models.GetEmployeeResponse;
import com.quintrix.james.JPADemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Integer id) {

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new IllegalStateException("Invalid Id");
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

		// My improvement
		Iterable<Employee> empl = employeeRepository.findAll();
		List<Employee> employeeList = Streamable.of(empl).toList();

		if (lastName != null) {
			getEmployeeResponse.setAvailableEmployeeList(employeeList.stream()
					.filter(e -> e.getLastName().equals(lastName))
					.map(e -> new ClientEmployee(e.getFirstName(), e.getLastName())).collect(Collectors.toList()));
		}

		getEmployeeResponse.setAvailableEmployee("Available");

		return getEmployeeResponse;
	}

	@Override
	public void deleteEmployeeById(Integer id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public GetEmployeeResponse getAllEmployees() {
		// This method retrieves all employees without directly accessing the database
		// and hides the id of each employee.

		GetEmployeeResponse getEmployeeResponse = new GetEmployeeResponse();

		// My improvement
		Iterable<Employee> empl = employeeRepository.findAll();
		List<Employee> employeeList = Streamable.of(empl).toList();

		getEmployeeResponse.setAvailableEmployeeList(employeeList.stream()
				.map(e -> new ClientEmployee(e.getFirstName(), e.getLastName())).collect(Collectors.toList()));

		getEmployeeResponse.setAvailableEmployee("Available");

		return getEmployeeResponse;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Employee updatedEmployee = employeeRepository.save(employee);

		return updatedEmployee;
	}

}
