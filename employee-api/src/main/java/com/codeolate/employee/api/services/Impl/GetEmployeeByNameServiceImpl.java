package com.codeolate.employee.api.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.GetEmployeeByIdService;
import com.codeolate.employee.api.services.GetEmployeeByNameService;

@Service
public class GetEmployeeByNameServiceImpl implements GetEmployeeByNameService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeListWrapper getEmployeeByName(String name) {
		EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
		employeeListWrapper.setListOfEmployee(employeeRepository.findByName(name));
		return employeeListWrapper;
	}

}
