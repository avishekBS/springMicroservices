package com.codeolate.employee.api.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.DeleteEmployeeService;

@Service
public class DeleteEmployeeServiceImpl implements DeleteEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String deleteEmployeeDetails(long id) {
		employeeRepository.deleteById(id);
		return "Employee id" + id +" has been deleted!!";
	}

}
