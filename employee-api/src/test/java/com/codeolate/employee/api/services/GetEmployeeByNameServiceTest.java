package com.codeolate.employee.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
class GetEmployeeByNameServiceTest {
	
	@Autowired
	private GetEmployeeByNameService getEmployeeByNameService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.build();
		List<Employee> employeeList =  new ArrayList<Employee>();
		employeeList.add(employee);
		Mockito.when(employeeRepository.findByName("Avishek")).thenReturn(employeeList);
	}

	@Test
	void whenValidEmployeeName_thenEmployeeDetailsShouldBeFound() {
		String name = "Avishek";
		EmployeeListWrapper employeeWrapper = null;
		employeeWrapper = getEmployeeByNameService.getEmployeeByName(name);
		assertEquals(name, employeeWrapper.getListOfEmployee().get(0).getName());
	}

}
