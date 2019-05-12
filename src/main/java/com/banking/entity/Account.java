package com.banking.entity;

import com.banking.exception.OverdraftException;

/**
 * Java 语言中面向对象的封装性及构造器的创建和使用。
 * 账号实体
 * @author taowd
 * @version 2019年5月12日
 * @see Account
 */
public class Account {

	/*
	 * 实验说明： ：
	 * 在这个练习里，创建一个简单版本的 Account 类。将这个源文件放入 banking 程
	 * 序包中。在创建单个帐户的默认程序包中，已编写了一个测试程序 TestBanking。
	 * 这个测试程序初始化帐户余额，并可执行几种简单的事物处理。最后，该测试程 序
	 * 显示该帐户的最终余额。
	 */

	protected double balance;

	public Account(double init_balance) {

		this.balance = init_balance;
	}

	public double getBalance() {

		return balance;
	}

	/**
	 * 存钱方法
	 * @param amt: 存款的钱数
	 * @return: 返回存款是否成功
	 */
	public boolean deposit(double amt) {

		this.balance += amt;
		return true;
	}

	/**
	 * @param amt
	 * @throws OverdraftException: 当余额不足时，抛出该异常.
	 */
	public void withdraw(double amt) {

		if (amt > balance) {
			throw new OverdraftException("资金不足", amt - balance);
		}

		this.balance -= amt;
	}

}
