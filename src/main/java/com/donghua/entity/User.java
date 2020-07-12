package com.donghua.entity;

import java.math.BigInteger;

public class User {

    private String account;
    private String name;
    private String card_type;
    private String card_id;
    private String pwd;
    private BigInteger money;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BigInteger getMoney() {
        return money;
    }

    public void setMoney(BigInteger money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", card_type='" + card_type + '\'' +
                ", card_id='" + card_id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", money=" + money +
                '}';
    }
}
