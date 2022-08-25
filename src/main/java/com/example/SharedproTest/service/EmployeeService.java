package com.example.SharedproTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Employee;
import com.example.SharedproTest.repository.DepartmentRepository;
import com.example.SharedproTest.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeRepository employeeRpository;
	
	@Autowired
	private DepartmentRepository departmentRpository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		if(employee.getEmpName().isEmpty() || employee.getEmpName().length() == 0 ) {
			throw new BusinessException("601","Please send proper name, It blank");
		}
		try {
			Employee savedEmployee = employeeRpository.save(employee);
			return savedEmployee;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602","given employee is null" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603","Something went wrong in Service layer while saving the employee" + e.getMessage());
		}

	}

	@Override
	public Employee getEmployeeeById(int empId) {
		try {
			return employeeRpository.findById(empId).get();
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("604","given employee id is null, please send some id to be searched" + e.getMessage());
		}
		catch (java.util.NoSuchElementException e) {
			throw new BusinessException("605","given employee id doesnot exist in DB" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("606","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
	}

	@Override
	public String deleteEmployee(int empId) {
		try {
			employeeRpository.deleteById(empId);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("607","given employee id is null, please send some id to be deleted" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("608","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		return empId+" is deleted.";
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = employeeRpository.findAll();
		}
		catch (Exception e) {
			throw new BusinessException("609","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		if(empList.isEmpty())
			throw new BusinessException("610", "Hey list completely empty, we have nothing to return");
		
		return empList;
	}

	@Override
	public List<Employee> getEmployeesByDeppartment(int deptId) {
		List<Employee> empList = null;
		try {
			Optional<Department> department = departmentRpository.findById(deptId);
			empList = employeeRpository.findByDepartment(department);
		}
		catch (Exception e) {
			throw new BusinessException("611","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		if(empList.isEmpty())
			throw new BusinessException("612", "Hey list completely empty, we have nothing to return");
		return empList;
	}

	@Override
	public List<Employee> getAllEmployeesSortByName() {
		List<Employee> empList = null;
		try {
			empList = employeeRpository.findAll(Sort.by("empName"));
		}
		catch (Exception e) {
			throw new BusinessException("613","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		if(empList.isEmpty())
			throw new BusinessException("614", "Hey list completely empty, we have nothing to return");
		
		return empList;
	}

	@Override
	public List<Employee> getAllEmployeesSortByCity() {
		List<Employee> empList = null;
		try {
			empList = employeeRpository.findAll(Sort.by("empCity"));
		}
		catch (Exception e) {
			throw new BusinessException("615","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		if(empList.isEmpty())
			throw new BusinessException("616", "Hey list completely empty, we have nothing to return");
		
		return empList;
	}

	@Override
	public List<Employee> getAllEmployeesSortByempBirthdate() {
		List<Employee> empList = null;
		try {
			empList = employeeRpository.findAll(Sort.by("empBirthdate"));
		}
		catch (Exception e) {
			throw new BusinessException("617","Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		if(empList.isEmpty())
			throw new BusinessException("618", "Hey list completely empty, we have nothing to return");
		
		return empList;
	}
}
