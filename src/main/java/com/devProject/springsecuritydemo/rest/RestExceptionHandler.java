package com.devProject.springsecuritydemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devProject.springsecuritydemo.entity.EmployeeErrorResponse;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
		
		EmployeeErrorResponse error = new EmployeeErrorResponse(404, exc.getMessage(), System.currentTimeMillis() );
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler for all type of exception
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
		EmployeeErrorResponse error = new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis() );
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
