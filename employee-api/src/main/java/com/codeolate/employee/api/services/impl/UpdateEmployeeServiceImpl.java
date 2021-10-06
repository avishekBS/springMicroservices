package com.codeolate.employee.api.services.impl;

import com.codeolate.employee.api.entity.Employee;

public interface UpdateEmployeeServiceImpl {

	Employee updateEmployee(Long id, Employee employee);

}