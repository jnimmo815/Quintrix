package com.quintrix.james.RestDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quintrix.james.RestDemo.entity.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
