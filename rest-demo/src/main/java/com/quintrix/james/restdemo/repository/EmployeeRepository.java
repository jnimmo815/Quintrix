package com.quintrix.james.restdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.james.restdemo.entity.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
