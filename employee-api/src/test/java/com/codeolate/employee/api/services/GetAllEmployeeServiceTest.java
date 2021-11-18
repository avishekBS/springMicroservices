package com.codeolate.employee.api.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.repositories.EmployeeRepository;

@SpringBootTest
class GetAllEmployeeServiceTest {

	@Autowired
	private GetAllEmployeeService getAllEmployeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.build();
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(employee);
		when(employeeRepository.findAll()).thenReturn(listOfEmployees);
	}

	@Test
	void whenValidEmployeeName_thenAllEmployeeDetailsShouldBeReturned() {
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.build();
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(employee);
		List<Employee> employees = getAllEmployeeService.getAllEmployee().getListOfEmployee();
		assertArrayEquals(listOfEmployees.toArray(), employees.toArray());
	}

}
