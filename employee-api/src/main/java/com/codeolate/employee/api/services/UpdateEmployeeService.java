package com.codeolate.employee.api.services;

import com.codeolate.employee.api.entity.Employee;

public interface UpdateEmployeeService {

	Employee updateEmployee(Long id, Employee employee);

}