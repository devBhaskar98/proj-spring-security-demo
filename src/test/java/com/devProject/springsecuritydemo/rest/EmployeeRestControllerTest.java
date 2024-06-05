package com.devProject.springsecuritydemo.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devProject.springsecuritydemo.entity.Employee;
import com.devProject.springsecuritydemo.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeRestControllerTest {

	
	@Mock
	EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeRestController empRestController;
	
	 // Create a list of Employee objects
    List<Employee> employees = Arrays.asList(
        new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com"),
        new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com")
    );
	
	@Test
	void getAllEmployees() {
		when(employeeService.findAll()).thenReturn(employees);
		List<Employee> employees = empRestController.getAllEmployees();
		
		assertEquals(2, employees.size());
	}
	
	@Test
	void getEmployee() {
		when(employeeService.findById(anyInt())).thenReturn(new Employee(2, "Emma", "Baumgarten", "emma@devproject.com"));
		Employee employee = empRestController.getEmployee(1);
		System.out.println("Test Result " + employee.getEmail());
//		assertEquals(2, employees.size());
	}
	
	   

}
