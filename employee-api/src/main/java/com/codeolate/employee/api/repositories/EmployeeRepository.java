package com.codeolate.employee.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeolate.employee.api.entity.Employee;
import java.lang.String;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByName(String name);
}
