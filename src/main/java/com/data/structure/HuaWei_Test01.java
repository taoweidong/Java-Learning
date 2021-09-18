package com.data.structure;

import java.util.Scanner;

/**
 * 最小公倍数 = 数字A * 数字B / 最小公约数
 * 
 * @author Taoweidong
 */
public class HuaWei_Test01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A * B / getResult(A, B));

    }

    /**
     * 求最大公约数
     * 
     * @param a
     *            数字A
     * @param b
     *            数字B
     * @return 最大公约数
     */
    private static int getResult(int a, int b) {
        if (a < b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int k = 1;
        while (b != 0) {
            k = a % b;
            a = b;
            b = k;
        }
        return a;
    }
}
