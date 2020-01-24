package com.example.crud.exception;

public class ResourceUpdateFailedException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	public ResourceUpdateFailedException(String message) {
		super();
		this.message=message;
	}

}
