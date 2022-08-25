package com.example.SharedproTest.service;

import java.util.List;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.model.Department;

public interface DepartmentServiceInterface {
	
	public Department saveDepartment(Department department) throws BusinessException;

	public Department getDepartmentrById(int profId);
	
	public String deleteDepartment(int profId);
	
	public List<Department> getAllDepartment();
}
