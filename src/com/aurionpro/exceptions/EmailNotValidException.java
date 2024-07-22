package com.aurionpro.exceptions;

public class EmailNotValidException extends RuntimeException{
	private String email;

	public EmailNotValidException(String email) {
		super();
		this.email = email;
	}

	public String getMessage() {
		return "Invalid email address. " +email ;
	}

}
