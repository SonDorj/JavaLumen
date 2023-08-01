package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.InValidVoterException;
import com.voterapp.service.ElectionBoothImpl;
import com.voterapp.service.IElectionBooth;

public class VoterMain {

	public static void main(String[] args) {
		IElectionBooth validator = new ElectionBoothImpl("Bangalore","Tamil Nadu","Kerala");
		int age;
		String locality;
		int VoterId;

		try (Scanner scanner = new Scanner(System.in);) {
			
			System.out.println("Welcome to voter");
			System.out.print("Enter age:\t");
			age = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Locality:\t");
			locality = scanner.nextLine();
			System.out.print("Enter VoterId:\t");
			VoterId = scanner.nextInt();
			if(validator.checkEligibility(age, locality, VoterId))
				System.out.println("User can vote");
			else
				System.out.println("User can't vote");
		} catch (InValidVoterException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
