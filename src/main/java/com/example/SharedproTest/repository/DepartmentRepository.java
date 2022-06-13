package com.example.SharedproTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SharedproTest.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
