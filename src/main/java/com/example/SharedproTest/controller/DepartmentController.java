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
import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Employee;
import com.example.SharedproTest.service.DepartmentServiceInterface;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentServiceInterface departmentServiceInterface;
	
	@PostMapping("/save")
	public ResponseEntity<?> createDepartment(@RequestBody Department department) {
		try {
			Department departmentSaved = departmentServiceInterface.saveDepartment(department);
			return new ResponseEntity<Department>(departmentSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("645","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Department> updateEmployee(@RequestBody Department department){
		Department employeeSaved = departmentServiceInterface.saveDepartment(department);
		return new ResponseEntity<Department>(employeeSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{deptId}")
	public ResponseEntity<?> getDepartmentById(@PathVariable int deptId) {
		try {
			Department deptRetrieved = departmentServiceInterface.getDepartmentrById(deptId);
			return new ResponseEntity<Department>(deptRetrieved, HttpStatus.OK);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("646","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{deptId}")
	public ResponseEntity<?> deleteDepartment(@PathVariable int deptId) {
		departmentServiceInterface.deleteDepartment(deptId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllDepartment(){
		List<Department> listOfAllDept = departmentServiceInterface.getAllDepartment();
		return new ResponseEntity<List<Department>>(listOfAllDept, HttpStatus.OK);
		}
	
}
