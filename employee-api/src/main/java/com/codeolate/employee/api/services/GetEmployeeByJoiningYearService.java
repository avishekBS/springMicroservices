package com.codeolate.employee.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.repositories.EmployeeRepository;
import com.codeolate.employee.api.services.impl.GetEmployeeByJoiningYearServiceImpl;

@Service
public class GetEmployeeByJoiningYearService implements GetEmployeeByJoiningYearServiceImpl{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeListWrapper getEmployeeByJoiningYear(int year) {
		EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
		employeeListWrapper.setListOfEmployee(employeeRepository.findByJoiningDateBetween(year));
		return employeeListWrapper;
	}


}
