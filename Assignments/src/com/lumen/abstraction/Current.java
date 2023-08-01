package com.lumen.abstraction;

public class Current extends Bank {

	public Current(double balance) {
		super(balance);
	}

	@Override
	void withdray(double amount) {
		if(amount<=balance) {
			balance-=amount;
			balance--;	//current account transaction charge
			System.out.println("Withdrawal of "+amount+" is successful!");
			System.out.println("Remaining Balance : "+balance);
		}
		System.out.println("Balance insufficient!");
	}

	@Override
	void deposit(double amount) {
		if(amount<0)
			System.out.println("Can't deposit -ve amount");
		else {
			System.out.println("Deposit of "+amount+" is successful!");
			balance--;	//current account transaction charge
			balance+=amount;
			System.out.println("Updated Balance : "+balance);
		}
	}

}
