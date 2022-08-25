package com.example.SharedproTest.service;

import java.util.List;

import com.example.SharedproTest.exception.BusinessException;
import com.example.SharedproTest.model.Professor;

public interface ProfessorServiceInterface {
	
public Professor saveProfessor(Professor professor) throws BusinessException;
	
	public Professor getProfessorById(int profId);
	
	public String deleteProfessor(int profId);
	
	public List<Professor> getAllProfessor();
	
	public List<Professor> getProfessorByDeppartment(int deptId);
	
	

}
