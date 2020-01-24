package com.example.crud.exception;

public class EmailAndMobNumNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;

	public EmailAndMobNumNotFoundException(String message) {
		super();
		this.message = message;
	}
}
