package com.codeolate.employee.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codeolate.employee.api.repositories.EmployeeRepository;

@SpringBootTest
class DeleteEmployeeServiceTest {
	
	@Autowired
	private DeleteEmployeeService deleteEmployeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Long employeeid = 839021L;
		verify(this.employeeRepository, times(0)).deleteById(employeeid);
	}

	@Test
	void whenValidEmployeeName_thenEmployeeDetailsShouldBeAdd() {
		Long employeeid = 839021L;
		String deleteEmployeeDetails = deleteEmployeeService.deleteEmployeeDetails(employeeid);
		assertEquals("Employee id839021 has been deleted!!", deleteEmployeeDetails);
	}

}
