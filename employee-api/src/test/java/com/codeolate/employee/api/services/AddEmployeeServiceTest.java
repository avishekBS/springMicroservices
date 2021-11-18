package com.codeolate.employee.api.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.entity.EmployeeListWrapper;
import com.codeolate.employee.api.repositories.EmployeeRepository;

@SpringBootTest
class AddEmployeeServiceTest {
	
	@Autowired
	private AddEmployeeService addEmployeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.build();
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
	}

	@Test
	void whenValidEmployee_thenEmployeeDetailsShouldBeAdd() {
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.build();
		String addEmployee = addEmployeeService.addEmployee(employee);
		assertEquals("Employee details saved!!", addEmployee);
	}

}
