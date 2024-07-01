package com.devProject.springsecuritydemo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devProject.springsecuritydemo.entity.Employee;
import com.devProject.springsecuritydemo.entity.PageRequestDto;
import com.devProject.springsecuritydemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private static final Logger logInfo = LoggerFactory.getLogger(EmployeeRestController.class);
	
	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService theEmployeeService) {
		super();
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employees/paginated")
	public Page<Employee> getAllEmployeesPaginatedResult(@RequestBody PageRequestDto dto){
		
		Pageable pageable = new PageRequestDto().getPageable(dto);
		Page<Employee> employeePage = employeeService.findAllByPagination(pageable);		
		
		return employeePage;
	
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		logInfo.info("get employee called with id " + employeeId);
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		Employee employeeDb = employeeService.save(theEmployee);
		logInfo.debug("new employee craeted with id " + employeeDb.getId());
		
		return employeeDb;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
	}
	
//	@ExceptionHandler
//	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
//		
//		EmployeeErrorResponse error = new EmployeeErrorResponse(404, exc.getMessage(), System.currentTimeMillis() );
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	
//	// add another exception handler for all type of exception
//	@ExceptionHandler
//	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
//		EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis() );
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	

}
