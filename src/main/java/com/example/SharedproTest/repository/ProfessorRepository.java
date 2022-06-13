package com.example.SharedproTest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SharedproTest.model.Department;
import com.example.SharedproTest.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	List<Professor> findByDepartment(Optional<Department> department);

}
