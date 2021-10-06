package com.codeolate.employee.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.impl.GetEmployeeByIdServiceImpl;

@Service
public class GetEmployeeByIdService implements GetEmployeeByIdServiceImpl{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElse(new Employee(id, "Id not found"));
		return employee;
	}
}
