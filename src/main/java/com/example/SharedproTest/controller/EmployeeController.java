package com.example.SharedproTest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Employee;
import com.example.SharedproTest.repository.DepartmentRepository;
import com.example.SharedproTest.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRpository;
	@Autowired
	private DepartmentRepository departmentRpository;
	private Object object;
	
	@PostMapping("/save")
	public Employee creatEmployee(@RequestBody Employee employee) {
		return employeeRpository.save(employee);
	}
	
	@GetMapping("/findByName/{name}")
	public Employee findByName(@PathVariable String name) {
		return employeeRpository.findByempName(name);
		}
	
	@GetMapping("/getByID/{empId}")
	public Optional<Employee> getEmployeeeById(@PathVariable int empId){
		return employeeRpository.findById(empId);		
		}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable int empId){
		employeeRpository.deleteById(empId);
		return empId+" is deleted.";
		}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return employeeRpository.findAll();
		}
	
	@GetMapping("/getByDepartment/{deptId}")
	public List<Employee> getEmployeesByDeppartment(@PathVariable int deptId){
		Optional<Department> department=departmentRpository.findById(deptId);
		return employeeRpository.findByDepartment(department);
				
	}
	
	@GetMapping("/SortByName")
	public List<Employee> getAllEmployeesSortByName(){
		return employeeRpository.findAll(Sort.by("empName"));
	}
	
	@GetMapping("/SortByCity")
	public List<Employee> getAllEmployeesSortByCity(){
		return employeeRpository.findAll(Sort.by("empCity"));
	}
	
	@GetMapping("/SortByBirthday")
	public List<Employee> getAllEmployeesSortByempBirthdate(){
		return employeeRpository.findAll(Sort.by("empBirthdate"));
	} 
	
	

}


	
