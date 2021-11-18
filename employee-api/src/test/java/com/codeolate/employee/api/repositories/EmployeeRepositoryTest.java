package com.codeolate.employee.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.codeolate.employee.api.entity.Address;
import com.codeolate.employee.api.entity.Employee;

@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		String sDate = "2014-12-08";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date joingDate = sf.parse(sDate);
		Address address = Address.builder()
				.id(2)
				.city("Tripura")
				.addressType("ok")
				.build();
		List<Address> listofAddress = new ArrayList<Address>();
		listofAddress.add(address);
		Employee employee = Employee.builder()
				.id(1L)
				.adharNumber("1234567891011")
				.panNumber("anything")
				.name("Avishek")
				.joiningDate(joingDate)
				.listofAddress(listofAddress)
				.build();
		entityManager.merge(employee);
	}

	@Test
	void whenFindByName_thenReturnListOfEmployee() {
		List<Employee> findByName = employeeRepository.findByName("Avishek");
		assertEquals(findByName.get(0).getName(), "Avishek");
	}

	@Test
	void whenFindByJoiningDateBetween_thenReturnListOfEmployee() throws ParseException {
		String sDate = "2014-12-08";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date joingDate = sf.parse(sDate);
		List<Employee> employee = employeeRepository.findByJoiningDateBetween(2014);
		assertEquals(employee.get(0).getJoiningDate(), joingDate);
		}

	@Test
	@Disabled
	void whenFindAll() {
		
	}

}
