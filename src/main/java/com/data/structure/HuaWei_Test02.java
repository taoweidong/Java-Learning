package com.data.structure;

import java.util.Scanner;

/**
 * 最小公倍数 = 数字A * 数字B / 最小公约数
 * 
 * @author Taoweidong
 */
public class HuaWei_Test02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double ans = fun(sc.nextDouble());
        System.out.printf("%.1f", ans);

    }

    /**
     * 计算n的立方根
     * 
     * @param n
     * @return
     */
    private static double fun(double n) {

        double x = 1.0;
        while (Math.abs(x * x * x - n) > 1e-9) {
            x = x - ((x * x * x - n) / (3 * x * x));
        }
        return x;
    }
}
