package com.codeolate.employee.api.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Address;
import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.AddEmployeeService;

@Service
public class AddEmployeeServiceImpl implements AddEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		if (save == null) {
			return "Employee details not saved!!";
		}
		return "Employee details saved!!";
	}
}
