package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exceptions.EmailNotValidException;
import com.aurionpro.exceptions.PasswordNotValidException;
import com.aurionpro.model.User;

public class UserTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email : ");
		String email = sc.next();
		
		System.out.println("Enter the password : ");
		String password = sc.next();
		
		try {
			User user = new User(email, password);
			System.out.println("User Created!");
			System.out.println(user);
			
		}
		catch(EmailNotValidException e) {
			System.out.println("Error : " +e.getMessage());
		}
		catch(PasswordNotValidException e) {
			System.out.println("Error : "+ e.getMessage());
		}
		sc.close();
		
	}
}
