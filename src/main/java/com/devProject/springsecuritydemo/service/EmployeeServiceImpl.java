package com.devProject.springsecuritydemo.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devProject.springsecuritydemo.dao.EmployeeDAO;
import com.devProject.springsecuritydemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	

	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		super();
		employeeDAO = theEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return employeeDAO.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
	}

}
