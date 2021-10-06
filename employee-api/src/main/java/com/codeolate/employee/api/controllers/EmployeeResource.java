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
import com.codeolate.employee.api.exception.EmployeeNotFoundException;
import com.codeolate.employee.api.services.Impl.AddEmployeeServiceImpl;
import com.codeolate.employee.api.services.Impl.DeleteEmployeeServiceImpl;
import com.codeolate.employee.api.services.Impl.GetAllEmployeeServiceImpl;
import com.codeolate.employee.api.services.Impl.GetEmployeeByIdServiceImpl;
import com.codeolate.employee.api.services.Impl.GetEmployeeByJoiningYearServiceImpl;
import com.codeolate.employee.api.services.Impl.GetEmployeeByNameServiceImpl;
import com.codeolate.employee.api.services.Impl.UpdateEmployeeServiceImpl;

@RestController
@RequestMapping(path="/employee")
public class EmployeeResource {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AddEmployeeServiceImpl addEmployeeServiceImpl;
	
	@Autowired
	private GetAllEmployeeServiceImpl getAllEmployeeServiceImpl;
	
	@Autowired
	private GetEmployeeByIdServiceImpl getEmployeeByIdServiceImpl;
	
	@Autowired
	private GetEmployeeByNameServiceImpl getEmployeeByNameServiceImpl;
	
	@Autowired
	private GetEmployeeByJoiningYearServiceImpl getEmployeeByJoiningYearServiceImpl;
	
	@Autowired
	private DeleteEmployeeServiceImpl deleteEmployeeServiceImpl;
	
	@Autowired
	private UpdateEmployeeServiceImpl updateEmployeeServiceImpl;
	
	@PostMapping()
	private String addEmployee(@Valid @RequestBody Employee employee) {
		logger.trace("Add Employee resource");
		return addEmployeeServiceImpl.addEmployee(employee);
	}
	
	@GetMapping()
	public EmployeeListWrapper getAllEmployee() {
		logger.trace("get all Employee resource");
		return getAllEmployeeServiceImpl.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
		logger.trace("get all Employee resource by Employee id");
		return getEmployeeByIdServiceImpl.getEmployeeById(id);
	}
	@GetMapping("/name/{name}")
	public EmployeeListWrapper getEmployeeByName(@PathVariable String name) {
		logger.trace("get all Employee resource by Employee Name");
		return getEmployeeByNameServiceImpl.getEmployeeByName(name);
	}
	@GetMapping("/year/{year}")
	public EmployeeListWrapper getEmployeeByJoiningYear(@PathVariable int year) {
		logger.trace("get all Employee resource with joining year "+ year);
		return getEmployeeByJoiningYearServiceImpl.getEmployeeByJoiningYear(year);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable long id, @Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
		logger.trace("update employee id "+ id);
		return updateEmployeeServiceImpl.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeDetails(@PathVariable long id) {
		logger.trace("delete employee id "+ id);
		return deleteEmployeeServiceImpl.deleteEmployeeDetails(id);
	}

}
