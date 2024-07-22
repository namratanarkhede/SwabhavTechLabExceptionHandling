package com.aurionpro.model;

import com.aurionpro.exceptions.OverDraftBalanceException;

public class CurrentAccount extends Account{

	private double OVER_DRAFT_LIMIT;
	public CurrentAccount(int accountNo, String name, double balance, double OVER_DRAFT_LIMIT) {
		super(accountNo, name, balance);
		this.OVER_DRAFT_LIMIT =OVER_DRAFT_LIMIT;
	}
	
	@Override
	public String toString() {
		return "CurrentAccount [OVER_DRAFT_LIMIT=" + OVER_DRAFT_LIMIT + ", AccountNo=" + getAccountNo()
				+ ", Name=" + getName() + ", Balance=" + getBalance() +  "]";
	}


	@Override
	public void debit(double amount) {
		if(amount > 0) {
			if(getBalance() - amount < -OVER_DRAFT_LIMIT) { 
				throw new OverDraftBalanceException(getBalance(), OVER_DRAFT_LIMIT);
			}
			setBalance(getBalance() - amount);
			System.out.println("Amount Debited: "+amount+ " Total Balance : " +getBalance());
			return;
		}
		System.out.println("Invalid amount. Please enter valid amount");
	}
	
	

}
