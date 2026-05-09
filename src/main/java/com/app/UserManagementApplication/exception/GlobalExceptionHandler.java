package com.app.UserManagementApplication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),HttpStatus.NOT_FOUND,request.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),HttpStatus.BAD_REQUEST,request.getDescription(false));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
	}
}
