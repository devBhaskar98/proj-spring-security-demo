package com.devProject.springsecuritydemo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devProject.springsecuritydemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Page<Employee> findAllByPagination(Pageable pageable);

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
