package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * java编程 输入任意的数（不超过1000000） 将其分解成两个质数相加的形式， 输出总共有多少总分解方式，分解因子不区分排序 example input 100 俩质数相加=100 100=3+97 100=11+89
 * 100=17+83 100=29+71 100=41+59 100=47+53 output 6 ———————————————— 版权声明：本文为CSDN博主「我阳某人的博客」的原创文章，遵循 CC 4.0 BY-SA
 * 版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/weixin_43278942/article/details/102696846
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200329_02_02 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println(countPrimes(in.nextInt()));
    }

    /**
     * 数字分解
     *
     * @param n
     *            待分解的数字
     * @return 分解数量
     */
    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        // 判断是否为素数
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }
        // 统计素数之和的个数
        int count = 0;
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i < arr.length / 2 + 1; i++) {
            if (arr[i] && arr[n - i] && i <= n - i) {
                count++;
            }
        }
        return count;
    }
}
