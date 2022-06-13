package com.example.SharedproTest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByDepartment(Optional<Department> department);
	
	Employee findByempName(String empName);
	
//	List<Employee> findByOrderByempCityAsc();
//	List<Employee> findByOrderByEmpNameAsc();
//	List<Employee> findByOrderByempBirthdateAsc();

//	List<Employee> findByEmpNameContaining(String empName, Sort sort);
}
