package com.codeolate.employee.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.services.impl.AddEmployeeServiceImpl;
import com.codeolate.employee.api.services.impl.GetAllEmployeeServiceImpl;

@RestController
@RequestMapping(path="/employee")
public class EmployeeResource {
	
	@Autowired
	private AddEmployeeServiceImpl addEmployeeService;
	
	@Autowired
	private GetAllEmployeeServiceImpl getAllEmployeeService;
	
	@PostMapping()
	private String addEmployee(@RequestBody Employee employee) {
		return addEmployeeService.addEmployee(employee);
	}
	
	@GetMapping()
	public EmployeeListWrapper getAllEmployee() {
		System.out.println("in getALL....");
		return getAllEmployeeService.getAllEmployee();
	}

}
