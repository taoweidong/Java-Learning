package com.nowcoder;

import java.util.Scanner;

/**
 * 动态规划-完全背包问题<br/>
 * 问题描述：有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。第 i 种物品的体积是 vi，价值是 wi 。 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值。
 *
 * @author Taoweidong
 */
public class KnapsackProblem2 {

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
                // max表示前i-1种物品中选取若干件物品放入剩余空间为j-k*v[i]的背包中所能得到的最大价值加上k件第i种物品；
                int max = 0;
                // 此处循环计算max的值，最大的值即为当前节点的最大价值
                for (int k = 0; k * v[i] <= j; k++) {
                    // 选择k件相同物品时重量最大为j的最大价值价值
                    int t = dp[i - 1][j - k * v[i]] + k * w[i];
                    if (max < t) {
                        max = t;
                    }
                }
                dp[i][j] = max;
            }
        }

        // 3、输出最后一个节点的值：也就是N个背包在容量为V的限制下的最大价值
        System.out.println(dp[N][V]);

    }

}
