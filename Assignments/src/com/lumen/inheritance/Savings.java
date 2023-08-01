package com.lumen.inheritance;

public class Savings extends Account {

	public Savings(double balance) {
		super(balance);
	}

	@Override
	void withdraw(double amount) {
		super.withdraw(amount);
	}

	@Override
	void deposit(double amount) {
		super.deposit(amount);
		balance+=10;
	}

}
