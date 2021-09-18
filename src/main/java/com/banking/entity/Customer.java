package com.banking.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �û�ʵ�壬һ���û���Ӧ����˺�
 * 
 * @author taowd
 * @version 2019��5��12��
 * @see Customer
 */
public class Customer {

    private String firstName;

    private String lastName;

    // ��ʾӵ�������ж���˻�
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
