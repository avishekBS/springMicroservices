package com.codeolate.employee.api.services.Impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.Address;
import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.UpdateEmployeeService;

@Service
public class UpdateEmployeeServiceImpl implements UpdateEmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private GetEmployeeByIdServiceImpl getEmployeeByIdServiceImpl;
	
	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee employeeObj = getEmployeeByIdServiceImpl.getEmployeeById(id);
		if(!employeeObj.getName().equalsIgnoreCase("Id not found")) {
			if(
					employee.getName().equalsIgnoreCase(employeeObj.getName())
					&& employee.getPanNumber().equalsIgnoreCase(employeeObj.getPanNumber())
					&& employee.getAdharNumber().equalsIgnoreCase(employee.getAdharNumber())
				) {
					if(Objects.nonNull(employee.getDateOfBirth()) &&
							employee.getDateOfBirth() != null) {
						employeeObj.setDateOfBirth(employee.getDateOfBirth());
					}
					if(Objects.nonNull(employee.getJoiningDate()) &&
							employee.getJoiningDate() != null) {
						employeeObj.setJoiningDate(employee.getJoiningDate());
					}
			}
				
			else
				return new Employee(id, "Name/ Pan number/ adhar number/ Address cant be updated");
		}
		return employeeRepository.save(employeeObj);
	}
}
