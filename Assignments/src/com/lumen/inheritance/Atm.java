package com.lumen.inheritance;

import java.util.Scanner;

public class Atm {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Account savingAccount = new Savings(0);
		Account currentAccount = new Current(0);
		int choice=0;
		boolean exit=false;
		while(!exit) {
			System.out.println("1.Savings\n2.Current");
			System.out.println("Enter the Account type: ");
			choice=scanner.nextInt();
			if(choice==1) {
				choice=0;
				Savings acc = (Savings)savingAccount;
				System.out.println("1.Withdraw\n2.Deposit\n3.Balance");
				System.out.println("Enter your choice: ");
				choice=scanner.nextInt();
				while(choice<1||choice>3) {
					System.out.println("Enter your choice: ");
					choice=scanner.nextInt();
				}
				if(choice==1) {
					System.out.println("Enter your amount: ");
					double amount=scanner.nextInt();
					acc.withdraw(amount);
				}
				else if(choice==2) {
					System.out.println("Enter your amount: ");
					double amount=scanner.nextInt();
					acc.deposit(amount);
				}
				else if(choice==3) {
					System.out.println(acc.getBalance());
				} else
					System.out.println("invalid choice");
			}
			else if(choice==2) {
				choice=0;
				Current acc = (Current)currentAccount;
				System.out.println("1.Withdraw\n2.Deposit\n3.Balance");
				System.out.println("Enter your choice: ");
				choice=scanner.nextInt();
				while(choice<1||choice>3) {
					System.out.println("Enter your choice: ");
					choice=scanner.nextInt();
				}
				if(choice==1) {
					System.out.println("Enter your amount: ");
					double amount=scanner.nextInt();
					acc.withdraw(amount);
				}
				else if(choice==2) {
					System.out.println("Enter your amount: ");
					double amount=scanner.nextInt();
					acc.deposit(amount);
				}
				else if(choice==3) {
					System.out.println(acc.getBalance());
				} else
					System.out.println("invalid choice");
			}
			else {
				System.out.println("Wrong Choice");
				exit=true;
			}
		}
		scanner.close();
	}
}
