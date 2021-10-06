package com.codeolate.employee.api.services;

import com.codeolate.employee.api.entity.Employee;

public interface GetEmployeeByIdService {

	Employee getEmployeeById(Long id);

}