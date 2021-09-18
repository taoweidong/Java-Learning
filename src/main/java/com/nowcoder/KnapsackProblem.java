package com.nowcoder;

import java.util.Scanner;

/**
 * 动态规划-0-1背包问题<br/>
 * 问题描述：有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。第 i 件物品的体积是 vi，价值是 wi。 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值。
 *
 * @author Taoweidong
 */
public class KnapsackProblem {

    public static void main(String[] args) {

        // 1、从输入流中获取数据
        Scanner sc = new Scanner(System.in);
        // 物品的个数
        int N = sc.nextInt();
        // 背包的容积
        int V = sc.nextInt();
        // 物品的体积:第i个元素表示第i个物品的体积
        int[] v = new int[N + 1];
        // 物品的价值:第i个元素表示第i个物品的价值
        int[] w = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        // 2、开始解析问题
        // 表示前i个物品最大容量为j时的最大价值
        int[][] dp = new int[N + 1][V + 1];
        // 初始化基本数据
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[0][1] = 0;
        }

        // 开始进行动态规划
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (v[i] > j) {
                    // 如果待添加的物品的重量v[i]已经超过了当前背包的最大容量j,说明该物品不可以添加到背包中，则当前位置的最大价值仍为前一个物品在此重量下的最大价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 否则，新增的商品容量小于当前背包容量j，则说明可以添加到背包中
                    // dp[i-1][j]:前i-1个物品在容量为j的情况下的最大价值
                    // dp[i-1][j-v[i]] + w[i]:前i-1个物品在容量为j-v[i](当前最大容量j减去当前物品的重量)的情况下的最大价值+当前物品的最大价值
                    // 两者取其最大值作为当前节点的价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        // 3、输出最后一个节点的值：也就是N个背包在容量为V的限制下的最大价值
        System.out.println(dp[N][V]);

    }

    /**
     * 问题描述：有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。第 i 件物品的体积是 vi，价值是 wi。
     *
     * @param n
     *            物品的个数
     * @param v
     *            背包的最大容量
     * @param vArr
     *            每个物品的容量(假设下标从1开始，对应每个物品)
     * @param valueArr
     *            每个物品的价值(假设下标从1开始，对应每个物品)
     * @return 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值
     */
    public static int getDp(int n, int v, int[] vArr, int[] valueArr) {

        // 规划表:表示前i个物品容量最大为j时的最大价值
        int[][] dp = new int[n + 1][v + 1];
        // 初始化基础数据
        for (int i = 0; i < dp.length; i++) {
            // 第一行设置为初始值0
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            // 第一列设置为初始值0
            dp[i][0] = 0;
        }

        // 开始规划结果
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                if (valueArr[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - vArr[i]] + valueArr[i]);
                }

            }
        }

        return dp[n][v];
    }

}
