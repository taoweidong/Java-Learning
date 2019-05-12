package com.banking.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用户实体，一个用户对应多个账号
 * @author taowd
 * @version 2019年5月12日
 * @see Customer
 */
public class Customer {

	private String firstName;

	private String lastName;

	// 表示拥护可以有多个账户
	private List<Account> accounts;

	public Customer(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

		accounts = new ArrayList<Account>();
	}

	public Account getAccount(int index) {

		return accounts.get(index);
	}

	public void addAccount(Account account) {

		accounts.add(account);
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public int getNumOfAccounts() {

		return accounts.size();
	}

	public Iterator<Account> getAccounts() {

		return accounts.iterator();
	}
}
