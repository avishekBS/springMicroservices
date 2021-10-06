package com.codeolate.employee.api.services;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.exception.EmployeeNotFoundException;

public interface GetEmployeeByIdService {

	Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

}