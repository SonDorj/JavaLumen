package com.lumen.inheritance;

public class Current extends Account{

	public Current(double balance) {
		super(balance);
	}

	@Override
	void withdraw(double amount) {
		super.withdraw(amount);
		balance-=1;	//transaction charge
	}

	@Override
	void deposit(double amount) {
		super.deposit(amount);
		balance-=10;
	}

}
