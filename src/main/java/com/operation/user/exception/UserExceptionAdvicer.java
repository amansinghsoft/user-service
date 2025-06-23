package com.operation.user.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionAdvicer {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({FieldValidationExcaption.class, DataIntegrityViolationException.class})
	public ResponseEntity<String> handleFieldValidationExcaption(RuntimeException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
