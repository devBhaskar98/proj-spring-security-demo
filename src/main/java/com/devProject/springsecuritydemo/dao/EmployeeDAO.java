package com.devProject.springsecuritydemo.dao;

import java.util.List;

import com.devProject.springsecuritydemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();

	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
