package com.example.crud.exception;

public class ResourceNotEnteredException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	public ResourceNotEnteredException(String message) {
		super();
		this.message=message;
	}

}
