package com.huawei;

import java.util.Scanner;

/**
 * 查找算式最小值：
 * 对于给定的10个整数，从中任意选出3个，代入算式X+XY-Y+Z,要求求出算式最小值
 * 例如：
 * 1 1 3 1 1 1 1 1 1 1
 * 结果：2
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200327_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入数据处理
            String[] str = sc.nextLine().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.valueOf(str[i]);
            }

            //开始遍历计算
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i != j) {
                        for (int k = 0; k < arr.length; k++) {
                            if (i != k && j != k) {
                                int value = arr[i] + arr[i] * arr[j] - arr[j] + arr[k];
                                min = Math.min(min, value);
                            }
                        }
                    }
                }
            }
            System.out.println(min);
        }
    }
}
