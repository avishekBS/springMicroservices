package com.codeolate.employee.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codeolate.employee.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByName(String name);

	@Query("from Employee where year(joiningDate) = ?1" )
	List<Employee> findByJoiningDateBetween(int joiningDate);
}
