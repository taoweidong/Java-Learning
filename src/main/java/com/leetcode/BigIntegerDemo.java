package com.leetcode;

import java.math.BigInteger;

public class BigIntegerDemo {

    public static void main(String[] args) {

        BigInteger big = BigInteger.valueOf(100);
        BigInteger big2 = BigInteger.valueOf(25);
        System.out.println(big.add(big2));
        System.out.println(big.subtract(big2));
        System.out.println(big.multiply(big2));
        System.out.println(big.divide(big2));
        System.out.println(big.mod(big2));

    }
}
