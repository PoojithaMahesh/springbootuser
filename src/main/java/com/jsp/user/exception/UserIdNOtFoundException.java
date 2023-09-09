package com.jsp.user.exception;

public class UserIdNOtFoundException extends RuntimeException{

	private String message;

	public String getMessage() {
		return message;
	}

	public UserIdNOtFoundException(String message) {
		super();
		this.message = message;
	}

	
}
