package com.codeolate.employee.api.controllers;

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
import com.codeolate.employee.api.services.UpdateEmployeeService;

@RestController
@RequestMapping(path="/employee")
public class EmployeeResource {
	
	@Autowired
	private AddEmployeeService addEmployeeService;
	
	@Autowired
	private GetAllEmployeeService getAllEmployeeService;
	
	@Autowired
	private GetEmployeeByIdService getEmployeeByIdService;
	
	@Autowired
	private DeleteEmployeeService deleteEmployeeService;
	
	@Autowired
	private UpdateEmployeeService updateEmployeeService;
	
	@PostMapping()
	private String addEmployee(@RequestBody Employee employee) {
		return addEmployeeService.addEmployee(employee);
	}
	
	@GetMapping()
	public EmployeeListWrapper getAllEmployee() {
		return getAllEmployeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return getEmployeeByIdService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee getAllEmployee(@PathVariable long id, @RequestBody Employee employee) {
		return updateEmployeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public String getAllEmployee(@PathVariable long id) {
		return deleteEmployeeService.deleteEmployeeDetails(id);
	}

}
