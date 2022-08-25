package com.example.SharedproTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.exception.ControllerException;
import com.example.SharedproTest.model.Employee;

import com.example.SharedproTest.service.EmployeeServiceInterface;



@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	 
	@PostMapping("/save")
	public ResponseEntity<?> creatEmployee(@RequestBody Employee employee) {
		try {
			Employee employeeSaved = employeeServiceInterface.saveEmployee(employee);
			return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("619","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employeeSaved = employeeServiceInterface.saveEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getById/{empId}")
	public ResponseEntity<?> getEmployeeeById(@PathVariable int empId){
		try {
			Employee empRetrieved = employeeServiceInterface.getEmployeeeById(empId);
			return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("620","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int empId){
		employeeServiceInterface.deleteEmployee(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
		}
	
	@GetMapping("/getByDepartment/{deptId}")
	public ResponseEntity<?> getEmployeesByDeppartment(@PathVariable int deptId){
		
		List<Employee> listOfAllEmps = employeeServiceInterface.getEmployeesByDeppartment(deptId);
		return new ResponseEntity<List<Employee>>(listOfAllEmps,HttpStatus.OK);
				
	}
	
	@GetMapping("/SortByName")
	public ResponseEntity<?> getAllEmployeesSortByName(){
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployeesSortByName();
		return new ResponseEntity<List<Employee>>(listOfAllEmps,HttpStatus.OK);
	}
	
	@GetMapping("/SortByCity")
	public ResponseEntity<?> getAllEmployeesSortByCity(){
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployeesSortByCity();
		return new ResponseEntity<List<Employee>>(listOfAllEmps,HttpStatus.OK);
	}
	
	@GetMapping("/SortByBirthday")
	public ResponseEntity<?> getAllEmployeesSortByempBirthdate(){
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployeesSortByempBirthdate();
		return new ResponseEntity<List<Employee>>(listOfAllEmps,HttpStatus.OK);
	}
	
	

}


	
