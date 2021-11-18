package com.codeolate.employee.api.services;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codeolate.employee.api.entity.Employee;
import com.codeolate.employee.api.repositories.EmployeeRepository;

@SpringBootTest
class GetEmployeeByJoiningYearServiceTest {

	@Autowired
	private GetEmployeeByJoiningYearService getEmployeeByJoiningYearService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		String sDate = "2014-12-08";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date joingDate = sf.parse(sDate);
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.joiningDate(joingDate)
				.build();
		List<Employee> employeeList =  new ArrayList<Employee>();
		employeeList.add(employee);
		Mockito.when(employeeRepository.findByJoiningDateBetween(2014)).thenReturn(employeeList);
	}

	@Test
	void whenValidJoiningDate_thenEmployeeDetailsShouldBeFound() throws ParseException {
		String sDate = "2014-12-08";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date joingDate = sf.parse(sDate);
		Employee employee = Employee.builder()
				.id(839021L)
				.adharNumber("839021")
				.name("Avishek")
				.joiningDate(joingDate)
				.build();
		List<Employee> employeeList =  new ArrayList<Employee>();
		employeeList.add(employee);
		List<Employee> employees = getEmployeeByJoiningYearService.getEmployeeByJoiningYear(2014).getListOfEmployee();
		assertArrayEquals(employeeList.toArray(), employees.toArray());
	}

}
