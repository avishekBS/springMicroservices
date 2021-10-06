package com.codeolate.employee.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.impl.GetEmployeeByIdServiceImpl;
import com.codeolate.employee.api.services.impl.GetEmployeeByNameServiceImpl;

@Service
public class GetEmployeeByNameService implements GetEmployeeByNameServiceImpl{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeListWrapper getEmployeeByName(String name) {
		System.out.println("name is -->"+name);
		EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
		employeeListWrapper.setListOfEmployee(employeeRepository.findByName(name));
		return employeeListWrapper;
	}

}
