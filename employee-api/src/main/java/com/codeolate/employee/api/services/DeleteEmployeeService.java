package com.codeolate.employee.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.impl.DeleteEmployeeServiceImpl;

@Service
public class DeleteEmployeeService implements DeleteEmployeeServiceImpl{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String deleteEmployeeDetails(long id) {
		employeeRepository.deleteById(id);
		return "Employee id" + id +" has been deleted!!";
	}

}
