package com.example.SharedproTest.controller;

import java.util.List;
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
import com.example.SharedproTest.model.Professor;
import com.example.SharedproTest.repository.DepartmentRepository;
import com.example.SharedproTest.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/save")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@GetMapping("/getByID/{profId}")
	public Optional<Professor> getProfessorById(@PathVariable int profId){
		return professorRepository.findById(profId);
	}
	
	@DeleteMapping("/delete/{profId}")
	public String deleteProfessor(@PathVariable int profId) {
		professorRepository.deleteById(profId);
		return profId+" is deleted";
	}
	
	@GetMapping("/getAll")
	public List<Professor> getAllProfessors(){
		return professorRepository.findAll();
	}
	@GetMapping("/getByDepartment/{deptId}")
	public List<Professor> getProfessorsByDepartment(@PathVariable int deptId){
		Optional<Department> department=departmentRepository.findById(deptId);
		return professorRepository.findByDepartment(department);
	}
}
