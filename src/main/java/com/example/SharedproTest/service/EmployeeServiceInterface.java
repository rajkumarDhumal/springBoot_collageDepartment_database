package com.example.SharedproTest.service;

import java.util.List;
import java.util.Optional;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Employee;



public interface EmployeeServiceInterface {
	
	public Employee saveEmployee(Employee employee) throws BusinessException;
	
	public Employee getEmployeeeById(int empId);
	
	public String deleteEmployee(int empId);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> getEmployeesByDeppartment(int deptId);
	
	public List<Employee> getAllEmployeesSortByName();
	
	public List<Employee> getAllEmployeesSortByCity();
	
	public List<Employee> getAllEmployeesSortByempBirthdate();
	

	
	
}
