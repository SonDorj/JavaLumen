package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.ValidationServiceImp;

public class Register {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] usernames= {"Blackacre","John","Doe"};
		ValidationServiceImp validator = new ValidationServiceImp(usernames);
		try {
			System.out.print("Enter the username: \t");
			String username = scanner.nextLine();
			if(validator.validateUserName(username)) {
				System.out.print("Enter the password : \t");
				String password = scanner.nextLine();
				if(validator.validatePassword(password)) {
					System.out.println("User can vote");
				}	
			}
		} catch (NameExistException | TooLongException | TooShortException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
