package com.example.SharedproTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.repository.DepartmentRepository;

@Service
public class DepartmentService implements DepartmentServiceInterface{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) throws BusinessException {
		if(department.getDeptName().isEmpty() || department.getDeptName().length() == 0 ) {
			throw new BusinessException("635","Please send proper name, It blank");
		}
		try {
			Department savedDepartment = departmentRepository.save(department);
			return savedDepartment;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("636","given department is null" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("637","Something went wrong in Service layer while saving the department" + e.getMessage());
		}
	}

	@Override
	public Department getDepartmentrById(int profId) {
		try {
			return departmentRepository.findById(profId).get();
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("638","given department id is null, please send some id to be searched" + e.getMessage());
		}
		catch (java.util.NoSuchElementException e) {
			throw new BusinessException("639","given department id doesnot exist in DB" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("640","Something went wrong in Service layer while fetching all departments" + e.getMessage());
		}
	}

	@Override
	public String deleteDepartment(int profId) {
		try {
			departmentRepository.deleteById(profId);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("641","given department id is null, please send some id to be deleted" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("642","Something went wrong in Service layer while fetching all departments" + e.getMessage());
		}
		return profId+" is deleted.";
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> deptList = null;
		try {
			deptList = departmentRepository.findAll();
		}
		catch (Exception e) {
			throw new BusinessException("643","Something went wrong in Service layer while fetching all departments" + e.getMessage());
		}
		if(deptList.isEmpty())
			throw new BusinessException("644", "Hey list completely empty, we have nothing to return");
		
		return deptList;
	}
	

}
