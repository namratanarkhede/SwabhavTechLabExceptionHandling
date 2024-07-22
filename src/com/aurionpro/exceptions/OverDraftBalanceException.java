package com.aurionpro.exceptions;

public class OverDraftBalanceException extends RuntimeException {
	private double balance;
	private double OVER_DRAFT_LIMIT;



	
	public OverDraftBalanceException(double balance, double OVER_DRAFT_LIMIT) {
		super();
		this.balance = balance;
		this.OVER_DRAFT_LIMIT = OVER_DRAFT_LIMIT;	
		
	}
	
	public String getMessage() {
		return "Uhhohh!! Overdraft limit exceeded. Cannot debit amount. "+"\nYour Over draft limit is : " +this.OVER_DRAFT_LIMIT + "\nBalance is :" +balance ;
	}

}
