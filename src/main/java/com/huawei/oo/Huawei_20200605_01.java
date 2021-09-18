package com.huawei.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 【求解连续数列】 > 已知连续正整数数列 {k}=k1,k2, k3,、ki ,的各个数相加之和为S，i=n，S大于0小于100000，0＜N＜100000) , 求此数列k.
 * <p>
 * >- 输人：包含两个参数，1) . 连续正整数列和S,2）数据里数列个数为N.， - 输出，如果有解输出数列K，如果无解输出一1,
 * <p>
 * - 示例： 输入：525 6 输出：85 86 87 88 89 90
 */
public class Huawei_20200605_01 {
    // 等差数列求和公式：Sn=na1+n(n-1)d/2；（d为公差）
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().trim().split(" ");
            int sn = Integer.valueOf(input[0]);
            int n = Integer.valueOf(input[1]);
            // 公差
            int d = 1;

            int a1 = sn - n * (n - 1) * d / 2;
            if (a1 % n != 0) {
                System.out.println(-1);
                return;
            }

            int first = a1 / n;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(String.valueOf(first + i));
            }

            System.out.println(String.join(" ", result));

        }
    }

}
