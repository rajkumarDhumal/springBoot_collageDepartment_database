package com.example.SharedproTest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/save")
	public Department createDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	@GetMapping("/getById/{deptId}")
	public Optional<Department> getDepartmentById(@PathVariable int deptId) {
		return departmentRepository.findById(deptId);
	}
	
	@DeleteMapping("/delete/{deptId}")
	public String deleteDepartment(@PathVariable int deptId) {
		departmentRepository.deleteById(deptId);
		return deptId+" is deleted.";
		}
	
	
}
