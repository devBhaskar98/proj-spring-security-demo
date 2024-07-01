package com.devProject.springsecuritydemo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devProject.springsecuritydemo.dao.EmployeeDAO;
import com.devProject.springsecuritydemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logInfo = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	private EmployeeDAO employeeDAO;
	

	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		super();
		employeeDAO = theEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		logInfo.trace("employee: findAll() invoked");
		return employeeDAO.findAll();
	}
	
	@Override
	public Page<Employee> findAllByPagination(Pageable pageable) {
		logInfo.trace("employee: findAll() Pagination invoked");
		return employeeDAO.findAllByPagination(pageable);
	}

	@Override
	public Employee findById(int theId) {
		logInfo.trace("employee: findById() invoked");
		return employeeDAO.findById(theId);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		logInfo.trace("employee: save invoked");
		return employeeDAO.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		logInfo.trace("employee: deletedById invoked");
		employeeDAO.deleteById(theId);
		
	}

}
