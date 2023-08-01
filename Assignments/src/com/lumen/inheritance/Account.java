package com.lumen.inheritance;

public class Account {
	double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}
	void withdraw(double amount) {
		if(amount<=balance)
			balance-=amount;
		else
			System.out.println("insufficient balance");
	}
	void deposit(double amount) {
		if(amount<0)
			System.out.println("cant deposit -ve amount");
		else
			balance+=amount;
	}
	double getBalance() {
		return balance;
	}
}
