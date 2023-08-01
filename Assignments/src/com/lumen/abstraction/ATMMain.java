package com.lumen.abstraction;

import java.util.Scanner;

public class ATMMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		Bank account = null;
		double amount;
		boolean exit = false;
		boolean exitAccount = false;
		while(!exit) {
			System.out.print("\nATM\n1.savings\t2.current\t3.exit\nChoose Bank Account Type :\t");
			choice = scanner.nextLine();
			if(choice.equals("1"))
				account = new Savings(10_000);	//default balance = 10_000;
			else if(choice.equals("2"))
				account = new Savings(10_000);	//default balance = 10_000;
			else if(choice.equals("3"))
				exit=true;
			else {
				System.out.println("enter valid choide");
				continue;
			}
			while(!exitAccount && !exit) {
				System.out.print("\nSavings\n1.withdraw\t2.deposit\t3.Balance\t4.exit\nChoose Action :\t");
				choice = scanner.nextLine();
				switch(choice) {
				case "1":
					System.out.print("Enter Amount: ");
					amount=scanner.nextDouble();
					scanner.nextLine();
					account.withdray(amount);
					break;
				case "2":
					System.out.print("Enter Amount: ");
					amount=scanner.nextDouble();
					scanner.nextLine();
					account.deposit(amount);
					break;
				case "3":	System.out.println(account.getBalance());	break;
				case "4":	System.out.println("Exited from Account");	exitAccount=true; break;
				default :	System.out.println("enter valid choice");	break;
				}
			}
		}
		scanner.close();
	}

}
