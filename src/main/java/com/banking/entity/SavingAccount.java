package com.banking.entity;

public class SavingAccount extends Account {

	// ÀûÂÊ
	@SuppressWarnings("unused")
	private double interestRate;

	public SavingAccount(double init_balance, double interestRate) {

		super(init_balance);
		this.interestRate = interestRate;
	}

}
