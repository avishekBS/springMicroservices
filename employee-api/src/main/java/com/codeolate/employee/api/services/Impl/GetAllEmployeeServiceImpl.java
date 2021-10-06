package com.codeolate.employee.api.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.GetAllEmployeeService;

@Service
public class GetAllEmployeeServiceImpl implements GetAllEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeListWrapper getAllEmployee() {
		EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(listOfEmployees::add);
		employeeListWrapper.setListOfEmployee(listOfEmployees);
		return employeeListWrapper;
	}
}
