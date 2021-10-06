package com.codeolate.employee.api.services;

import com.codeolate.employee.api.entity.EmployeeListWrapper;

public interface GetEmployeeByNameService {

	EmployeeListWrapper getEmployeeByName(String name);

}