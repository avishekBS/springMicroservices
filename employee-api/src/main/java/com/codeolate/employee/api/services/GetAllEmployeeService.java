package com.codeolate.employee.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.model.Employee;
import com.codeolate.employee.api.model.EmployeeListWrapper;
import com.codeolate.employee.api.repositories.EmployeeRepository;

@Service
public class GetAllEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeListWrapper getAllEmployee() {
		EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(listOfEmployees::add);
		employeeListWrapper.setListOfEmployee(listOfEmployees);
		return employeeListWrapper;
	}
}
