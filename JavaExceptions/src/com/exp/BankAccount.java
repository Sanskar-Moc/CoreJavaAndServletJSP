package com.exp;

public class BankAccount {

	private int balance=100;
	
	public void withdraw(int amount) throws InsufficientFundsException {
		if(amount<balance)
		this.balance-=amount;
		else {
			InsufficientFundsException ife=new InsufficientFundsException("Insufficient Balance in the account.");
			throw ife;
		}
	}
}
