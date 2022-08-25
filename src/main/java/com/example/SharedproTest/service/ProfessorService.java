package com.example.SharedproTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Professor;
import com.example.SharedproTest.repository.DepartmentRepository;
import com.example.SharedproTest.repository.ProfessorRepository;

@Service
public class ProfessorService implements ProfessorServiceInterface{
	
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Professor saveProfessor(Professor professor) throws BusinessException {
		if(professor.getProfName().isEmpty() || professor.getProfName().length() == 0 ) {
			throw new BusinessException("621","Please send proper name, It blank");
		}
		try {
			Professor savedProfessor = professorRepository.save(professor);
			return savedProfessor;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("622","given professor is null" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("623","Something went wrong in Service layer while saving the professor" + e.getMessage());
		}
	}

	@Override
	public Professor getProfessorById(int profId) {
		try {
			return professorRepository.findById(profId).get();
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("624","given professor id is null, please send some id to be searched" + e.getMessage());
		}
		catch (java.util.NoSuchElementException e) {
			throw new BusinessException("625","given professor id doesnot exist in DB" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("626","Something went wrong in Service layer while fetching all professors" + e.getMessage());
		}
	}

	@Override
	public String deleteProfessor(int profId) {
		try {
			professorRepository.deleteById(profId);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("627","given professor id is null, please send some id to be deleted" + e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("628","Something went wrong in Service layer while fetching all professors" + e.getMessage());
		}
		return profId+" is deleted.";
	}

	@Override
	public List<Professor> getAllProfessor() {
		List<Professor> profList = null;
		try {
			profList = professorRepository.findAll();
		}
		catch (Exception e) {
			throw new BusinessException("629","Something went wrong in Service layer while fetching all professors" + e.getMessage());
		}
		if(profList.isEmpty())
			throw new BusinessException("630", "Hey list completely empty, we have nothing to return");
		
		return profList;
	}

	@Override
	public List<Professor> getProfessorByDeppartment(int deptId) {
		List<Professor> profList = null;
		try {
			Optional<Department> department = departmentRepository.findById(deptId);
			profList = professorRepository.findByDepartment(department);
		}
		catch (Exception e) {
			throw new BusinessException("631","Something went wrong in Service layer while fetching all professors" + e.getMessage());
		}
		if(profList.isEmpty())
			throw new BusinessException("632", "Hey list completely empty, we have nothing to return");
		
		return profList;
	}

	

}
