package com.example.crud.exception;

public class ResourceIdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@SuppressWarnings("unused")
		private String message;
		public ResourceIdNotFoundException(String message) {
			super(message);
			this.message=message;
		}
	}

