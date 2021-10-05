package com.codeolate.employee.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.model.Address;
import com.codeolate.employee.api.model.Employee;
import com.codeolate.employee.api.repositories.EmployeeRepository;

@Service
public class AddEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public String addEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		if (save == null) {
			return "Employee details not saved!!";
		}
		return "Employee details saved!!";
	}
}
