package com.codeolate.employee.api.services.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.exception.EmployeeNotFoundException;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.GetEmployeeByIdService;

@Service
public class GetEmployeeByIdServiceImpl implements GetEmployeeByIdService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employee.isPresent()) 
			throw new EmployeeNotFoundException("Employee Id "+id+ " not found!!");
		return employee.get();
	}
}
