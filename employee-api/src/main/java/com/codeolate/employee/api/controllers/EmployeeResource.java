package com.codeolate.employee.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeolate.employee.api.model.Employee;
import com.codeolate.employee.api.model.EmployeeListWrapper;
import com.codeolate.employee.api.services.AddEmployeeService;
import com.codeolate.employee.api.services.GetAllEmployeeService;

@RestController
@RequestMapping(path="/employee")
public class EmployeeResource {
	
	@Autowired
	private AddEmployeeService addEmployeeService;
	
	@Autowired
	private GetAllEmployeeService getAllEmployeeService;
	
	@PostMapping(path = "/add")
	private String addEmployee(@RequestBody Employee employee) {
		return addEmployeeService.addEmployee(employee);
	}
	
	@GetMapping(path = "/getAll")
	public EmployeeListWrapper getAllEmployee() {
		System.out.println("in getALL....");
		return getAllEmployeeService.getAllEmployee();
	}

}
