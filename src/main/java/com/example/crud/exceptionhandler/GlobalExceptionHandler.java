package com.example.crud.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.crud.exception.ErrorResponse;
import com.example.crud.exception.ResourceIdNotFoundException;
import com.example.crud.exception.ResourceNotEnteredException;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.exception.ResourceUpdateFailedException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceIdNotFoundException(ResourceIdNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ResourceNotEnteredException.class)
	public ResponseEntity<ErrorResponse> resourceNotEnteredException(ResourceNotEnteredException ex) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ResourceUpdateFailedException.class)
	public ResponseEntity<ErrorResponse> resourceUpdateFailedException(ResourceUpdateFailedException ex) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
	}

}
