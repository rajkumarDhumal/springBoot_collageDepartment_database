package com.example.SharedproTest.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.SharedproTest.model.Professor;
import com.example.SharedproTest.repository.DepartmentRepository;
import com.example.SharedproTest.repository.ProfessorRepository;
import com.example.SharedproTest.service.ProfessorServiceInterface;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorServiceInterface professorServiceInterface;

	
	@PostMapping("/save")
	public ResponseEntity<?> createProfessor(@RequestBody Professor professor) {
		try {
			Professor employeeSaved = professorServiceInterface.saveProfessor(professor);
			return new ResponseEntity<Professor>(employeeSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("633","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Professor professor){
		Professor employeeSaved = professorServiceInterface.saveProfessor(professor);
		return new ResponseEntity<Professor>(employeeSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{profId}")
	public ResponseEntity<?> getProfessorById(@PathVariable int profId){
		try {
			Professor empRetrieved = professorServiceInterface.getProfessorById(profId);
			return new ResponseEntity<Professor>(empRetrieved, HttpStatus.OK);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("634","Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{profId}")
	public ResponseEntity<?> deleteProfessor(@PathVariable int profId) {
		professorServiceInterface.deleteProfessor(profId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProfessors(){
		List<Professor> listOfAllEmps = professorServiceInterface.getAllProfessor();
		return new ResponseEntity<List<Professor>>(listOfAllEmps, HttpStatus.OK);
	}
	@GetMapping("/getByDepartment/{deptId}")
	public ResponseEntity<?> getProfessorsByDepartment(@PathVariable int deptId){
		List<Professor> listOfAllEmps = professorServiceInterface.getProfessorByDeppartment(deptId);
		return new ResponseEntity<List<Professor>>(listOfAllEmps,HttpStatus.OK);
	}
}
