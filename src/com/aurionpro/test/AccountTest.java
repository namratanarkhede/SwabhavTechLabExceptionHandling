package com.aurionpro.test;

import java.util.Random;
import java.util.Scanner;

import com.aurionpro.exceptions.MinimumBalanceException;
import com.aurionpro.exceptions.OverDraftBalanceException;
import com.aurionpro.model.Account;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAccount;

public class AccountTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		Account account = null;
		while(true) {
			displayMenu();
			int choice = scanner.nextInt();
			account = processChoice(choice, scanner, account, random);
			
		}
	}
	public static void displayMenu() {
		System.out.println("\n Menu : ");
		System.out.println("1.Create Account");
		System.out.println("2.Credit to Account");
		System.out.println("3.Debit from Account");
		System.out.println("4.Display Account Details");
		System.out.println("5.Exit");
	}

	private static Account processChoice(int choice, Scanner scanner, Account account,Random random) {

		switch(choice){
		case 1:
			account = createAccount(scanner, random);
			break;
		case 2:
			if(account!=null) {
				creditToAccount(scanner, account);
				return account;
			}
			System.out.println("Account not created.");
			break;
		case 3:
			if(account !=null) {
				debitFromAccount(scanner, account);
				return account;
			}
			System.out.println("Account not created");
			break;
		case 4:
			if(account !=null) {
				return account;
			}
			System.out.println("Account not created");
			break;
		case 5:
			System.out.println("Exit");
			scanner.close();
			return null;
		default:
			System.out.println("Invalid choice.");
			
		}
		return account;
	}

	private static Account createAccount(Scanner scanner, Random random) {
		System.out.println("Select the account type: ");
		System.out.println("1.Current Account");
		System.out.println("2.Saving Account");
		int type = scanner.nextInt();
		
		int accountNo = random.nextInt(1000000000);
        scanner.nextLine(); 

        System.out.println("Enter Account Holder Name: ");
        String name = scanner.next();

        System.out.println("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
		
        if(type ==1) {
        	System.out.println("Enter the Overdraft Limit: ");
        	double OVER_DRAFT_LIMIT = scanner.nextDouble();
        	return new CurrentAccount(accountNo, name, balance, OVER_DRAFT_LIMIT);
        }
        if(type == 2) {
        	System.out.println("Enter the Minimum Balance: ");
        	double MIN_BALANCE= scanner.nextDouble();
        	return new SavingAccount(accountNo, name, balance, MIN_BALANCE);
        }
        System.out.println("Invalid Inputs");
        return null;
	}
	private static void debitFromAccount(Scanner scanner, Account account) {
		try {
		System.out.println("Enter the amount to debit: ");
		double amount = scanner.nextDouble();
		account.debit(amount);
		}
		catch(MinimumBalanceException e){
			System.out.println(e.getMessage());
		}
		catch(OverDraftBalanceException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void creditToAccount(Scanner scanner, Account account) {
		System.out.println("Enter the amount to credit: ");
		double amount = scanner.nextDouble();
		account.credit(amount);
	}

}
