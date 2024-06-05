package com.devProject.springsecuritydemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.devProject.springsecuritydemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	

	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return employee list
		return employees;
		
	}

	@Override
	public Employee findById(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		
		return employee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		
		// set id to 0 , to create new employee instead of editing
		theEmployee.setId(0);
		
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		return dbEmployee;
		
	}

	@Override
	public void deleteById(int theId) {
		
		Employee employee = entityManager.find(Employee.class, theId);
		
		entityManager.remove(employee);
		
	}

}
