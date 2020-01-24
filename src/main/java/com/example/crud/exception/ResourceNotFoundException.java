package com.example.crud.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;

	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
