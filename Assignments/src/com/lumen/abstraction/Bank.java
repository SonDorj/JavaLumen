package com.lumen.abstraction;

public abstract class Bank {
	double balance;

	public Bank(double balance) {
		this.balance = balance;
	}

	abstract void withdray(double amount);
	abstract void deposit(double amount);
	double getBalance() {
		return this.balance;
	}
}
