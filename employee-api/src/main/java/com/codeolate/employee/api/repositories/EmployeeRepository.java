package com.codeolate.employee.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codeolate.employee.api.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
