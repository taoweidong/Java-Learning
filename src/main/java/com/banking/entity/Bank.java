package com.banking.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �������ж���
 * 
 * @author Think Pad
 *
 */
public class Bank {

    // ��ǰ Bank ���ж�� Cutomer
    private List<Customer> customers;

    private Bank() {
        customers = new ArrayList<Customer>();
    }

    private static Bank instance = new Bank();

    public static Bank getBank() {
        return instance;
    }

    /**
     * ���ݴ���Ĳ�������һ���µ� Cusotmer ����, ���Ѹö��󸳸� customers ��ָ����Ԫ��
     * 
     * @param firstName
     * @param lastName
     */
    public void addCustomer(String firstName, String lastName) {
        // 1.���ݴ���Ĳ�������һ���µ� Cusotmer ����
        Customer cust = new Customer(firstName, lastName);

        customers.add(cust);
    }

    /**
     * ���� ��ʾ customers �������ж��ٸ������� Customer ���������
     * 
     * @return
     */
    public int getNumOfCustomers() {
        return customers.size();
    }

    /**
     * ����ָ��������Ӧ�� Customer ����
     * 
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public Iterator<Customer> getCustomers() {
        return customers.iterator();
    }
}
