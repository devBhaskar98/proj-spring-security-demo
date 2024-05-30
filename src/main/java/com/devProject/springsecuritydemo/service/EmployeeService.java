package com.devProject.springsecuritydemo.service;

import java.util.List;

import com.devProject.springsecuritydemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
