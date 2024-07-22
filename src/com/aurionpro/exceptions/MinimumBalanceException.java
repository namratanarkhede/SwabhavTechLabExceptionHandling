package com.aurionpro.exceptions;

public class MinimumBalanceException extends RuntimeException{

	private double balance;
	private double MIN_BALANCE;



	
	public MinimumBalanceException(double balance, double MIN_BALANCE) {
		super();
		this.balance = balance;
		this.MIN_BALANCE = MIN_BALANCE;
	}
	public String getMessage() {
		return "Uhhohh!! Minimum balance requirement not met. cannot debit amount "+"\nYour Minimum Balance limit is : " +this.MIN_BALANCE + "\nBalance is :" +balance;
	}
}
