package com.algorithm;

/**
 * 如何⾼效寻找素数:
 * 素数的定义：素数的定义看起来很简单，如果⼀个数如果只能被 1 和它本⾝整除，那么这个数就是素数。
 */
public class Algorithm_20200626 {

    public static void main(String[] args) {

        System.out.println(countPrimes(10));

    }

    /**
     * 返回区间[2,n)中有几个素数
     *
     * @param n 区间终点
     * @return 素数的个数
     */
    public static int countPrimes(int n) {

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrim(i)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isPrim(int n) {

        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                //说明除了1和本身还有其他的整除因子，不是素数，是一个合数
                return false;
            }
        }
        return true;
    }


}
