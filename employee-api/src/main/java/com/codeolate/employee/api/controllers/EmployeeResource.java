package com.codeolate.employee.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.services.AddEmployeeService;
import com.codeolate.employee.api.services.DeleteEmployeeService;
import com.codeolate.employee.api.services.GetAllEmployeeService;
import com.codeolate.employee.api.services.GetEmployeeByIdService;
import com.codeolate.employee.api.services.GetEmployeeByJoiningYearService;
import com.codeolate.employee.api.services.GetEmployeeByNameService;
import com.codeolate.employee.api.services.UpdateEmployeeService;

@RestController
@RequestMapping(path="/employee")
public class EmployeeResource {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AddEmployeeService addEmployeeService;
	
	@Autowired
	private GetAllEmployeeService getAllEmployeeService;
	
	@Autowired
	private GetEmployeeByIdService getEmployeeByIdService;
	
	@Autowired
	private GetEmployeeByNameService getEmployeeByNameService;
	
	@Autowired
	private GetEmployeeByJoiningYearService getEmployeeByJoiningYearService;
	
	@Autowired
	private DeleteEmployeeService deleteEmployeeService;
	
	@Autowired
	private UpdateEmployeeService updateEmployeeService;
	
	@PostMapping()
	private String addEmployee(@Valid @RequestBody Employee employee) {
		logger.trace("Add Employee resource");
		return addEmployeeService.addEmployee(employee);
	}
	
	@GetMapping()
	public EmployeeListWrapper getAllEmployee() {
		logger.trace("get all Employee resource");
		return getAllEmployeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		logger.trace("get all Employee resource by Employee id");
		return getEmployeeByIdService.getEmployeeById(id);
	}
	@GetMapping("/name/{name}")
	public EmployeeListWrapper getEmployeeByName(@PathVariable String name) {
		logger.trace("get all Employee resource by Employee Name");
		return getEmployeeByNameService.getEmployeeByName(name);
	}
	@GetMapping("/year/{year}")
	public EmployeeListWrapper getEmployeeByJoiningYear(@PathVariable int year) {
		logger.trace("get all Employee resource with joining year "+ year);
		return getEmployeeByJoiningYearService.getEmployeeByJoiningYear(year);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable long id, @Valid @RequestBody Employee employee) {
		logger.trace("update employee id "+ id);
		return updateEmployeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeDetails(@PathVariable long id) {
		logger.trace("delete employee id "+ id);
		return deleteEmployeeService.deleteEmployeeDetails(id);
	}

}
