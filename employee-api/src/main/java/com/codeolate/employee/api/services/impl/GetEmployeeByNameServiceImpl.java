package com.codeolate.employee.api.services.impl;

import com.codeolate.employee.api.entity.EmployeeListWrapper;

public interface GetEmployeeByNameServiceImpl {

	EmployeeListWrapper getEmployeeByName(String name);

}