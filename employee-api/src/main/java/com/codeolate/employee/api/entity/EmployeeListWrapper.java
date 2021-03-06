package com.codeolate.employee.api.entity;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListWrapper {
	
	private List<Employee> listOfEmployee;
	
	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}
	
}
