package com.offer;

import com.alibaba.fastjson.JSON;

/**
 * 问题描述：有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。第 i 件物品的体积是 vi，价值是 wi。
 *
 * @author Taoweidong
 */
public class HuaWeiTest_02 {
    public static void main(String[] args) {
        // 初始赋值操作
        int[] value = new int[]{0, 1500, 3000, 2000};
        int[] weight = new int[]{0, 1, 4, 3};
        int v = 4;
        int n = 3;

        //规划表:表示前i个物品容量最大为j时的最大价值
        int[][] dp = new int[n + 1][v + 1];

        System.out.println(getDp(n, v, weight, value));


    }

    /**
     * 问题描述：有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。第 i 件物品的体积是 vi，价值是 wi。
     *
     * @param n        物品的个数
     * @param v        背包的最大容量
     * @param vArr     每个物品的容量(假设下标从1开始，对应每个物品)
     * @param valueArr 每个物品的价值(假设下标从1开始，对应每个物品)
     * @return 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值
     */
    public static int getDp(int n, int v, int[] vArr, int[] valueArr) {

        //规划表:表示前i个物品容量最大为j时的最大价值
        int[][] dp = new int[n + 1][v + 1];

        //开始规划结果
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (vArr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vArr[i]] + valueArr[i]);
                }

            }
        }

        System.out.println(JSON.toJSONString(dp));

        return dp[n][v];
    }
}
