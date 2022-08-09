package com.mohammad.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mohammad.exception.TaskErrorResponse;
import com.mohammad.exception.TaskNotFoundException;

@ControllerAdvice
public class TaskRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleException(TaskNotFoundException exc){
		TaskErrorResponse error = new TaskErrorResponse(HttpStatus.NOT_FOUND.value()
				, exc.getMessage()
				, System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<TaskErrorResponse> handleException(Exception exc){
		TaskErrorResponse error = new TaskErrorResponse(HttpStatus.BAD_REQUEST.value()
				, exc.getMessage()
				, System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
