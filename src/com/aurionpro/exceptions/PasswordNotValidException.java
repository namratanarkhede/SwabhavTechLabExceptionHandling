package com.aurionpro.exceptions;

public class PasswordNotValidException extends RuntimeException{
	private String password;

	public PasswordNotValidException(String password) {
		super();
		this.password = password;
	}
	public String getMessage() {
		return "Invalid Password."+ password +"\n Password sholud be greater than 8 charcter. \n Password must contain atleast one Capital letter. \n Password must contain one small letter. \n Password must Numeric Value. \n Password must contain Special Charcter.";
		
	}

}
