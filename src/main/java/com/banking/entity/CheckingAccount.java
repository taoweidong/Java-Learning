package com.banking.entity;

import com.banking.exception.OverdraftException;

public class CheckingAccount extends Account {

	// ��ʾ͸֧����
	private Double overdraftProtection;

	public CheckingAccount(double init_balance) {

		super(init_balance);
	}

	public CheckingAccount(double init_balance, double overdraftProtection) {

		super(init_balance);
		this.overdraftProtection = overdraftProtection;
	}

	@Override
	public void withdraw(double amt) {

		if (balance >= amt) {
			balance -= amt;
		} else {
			if (overdraftProtection == null) {
				throw new OverdraftException("no overdraft protection", (amt - balance));
			}
			if (overdraftProtection >= (amt - balance)) {
				overdraftProtection -= (amt - balance);
				balance = 0;
			} else {
				throw new OverdraftException("Insufficient funds for overdraft protection",
						(amt - balance));
			}
		}

	}

}
