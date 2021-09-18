package com.banking.entity;

import com.banking.exception.OverdraftException;

/**
 * Java �������������ķ�װ�Լ��������Ĵ�����ʹ�á� �˺�ʵ��
 * 
 * @author taowd
 * @version 2019��5��12��
 * @see Account
 */
public class Account {

    /*
     * ʵ��˵���� ��
     * �������ϰ�����һ���򵥰汾�� Account �ࡣ�����Դ�ļ����� banking ��
     * ����С��ڴ��������ʻ���Ĭ�ϳ�����У��ѱ�д��һ�����Գ��� TestBanking��
     * ������Գ����ʼ���ʻ�������ִ�м��ּ򵥵����ﴦ����󣬸ò��Գ� ��
     * ��ʾ���ʻ���������
     */

    protected double balance;

    public Account(double init_balance) {

        this.balance = init_balance;
    }

    public double getBalance() {

        return balance;
    }

    /**
     * ��Ǯ����
     * 
     * @param amt:
     *            ����Ǯ��
     * @return: ���ش���Ƿ�ɹ�
     */
    public boolean deposit(double amt) {

        this.balance += amt;
        return true;
    }

    /**
     * @param amt
     * @throws OverdraftException:
     *             ������ʱ���׳����쳣.
     */
    public void withdraw(double amt) {

        if (amt > balance) {
            throw new OverdraftException("�ʽ���", amt - balance);
        }

        this.balance -= amt;
    }

}
