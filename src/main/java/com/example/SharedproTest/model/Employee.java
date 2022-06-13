package com.example.SharedproTest.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private String empCity;
	private Date empBirthdate;
	
	@ManyToOne
	@JsonBackReference
	private Department department;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	public Date getEmpBirthdate() {
		return empBirthdate;
	}

	public void setEmpBirthdate(Date empBirthdate) {
		this.empBirthdate = empBirthdate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
	
}
