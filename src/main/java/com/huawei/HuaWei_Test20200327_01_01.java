package com.huawei;

import java.util.Scanner;

/**
 * 查找算式最小值：
 * 对于给定的10个整数，从中任意选出3个，代入算式X+XY-Y+Z,要求求出算式最小值
 * 例如：
 * 1 1 3 1 1 1 1 1 1 1
 * 结果：2
 * https://blog.csdn.net/weixin_39971186/article/details/103315477
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200327_01_01 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int y = 0;
        for (int i = 0; i < 10; i++) {
            int x = arr[i];
            for (int j = 0; j < 10; j++) {

                if (j != i) {
                    y = arr[j];
                } else {
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    if (k != j && k != i) {
                        if (i == 0) {
                            min = x + x * y - y + arr[k];
                        } else {
                            int temp = x + x * y - y + arr[k];
                            if (temp < min) {
                                min = temp;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
