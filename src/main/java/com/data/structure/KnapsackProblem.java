package com.data.structure;

import java.util.Scanner;

/**
 * 动态规划-背包问题
 * @author Taoweidong
 */
public class KnapsackProblem {

	public static void main(String[] args) {

		//1、从输入流中获取数据
		Scanner sc = new Scanner(System.in);
		//物品的个数
		int N = sc.nextInt();
		//背包的容积
		int V = sc.nextInt();
		//物品的体积:第i个元素表示第i个物品的体积
		int[] v = new int[N + 1];
		//物品的价值:第i个元素表示第i个物品的价值
		int[] w = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}

		//2、开始解析问题
		//表示前i个物品最大容量为j时的最大价值
		int[][] dp = new int[N + 1][V + 1];
		//初始化基本数据
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[0][1] = 0;
		}

		//开始进行动态规划
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {

				if (v[i] > j) {
					//如果待添加的物品的重量v[i]已经超过了当前背包的最大容量j,说明该物品不可以添加到背包中，则当前位置的最大价值仍为前一个物品在此重量下的最大价值
					dp[i][j] = dp[i - 1][j];
				} else {
					//否则，新增的商品容量小于当前背包容量j，则说明可以添加到背包中
					//dp[i-1][j]:前i-1个物品在容量为j的情况下的最大价值
					//dp[i-1][j-v[i]] + w[i]:前i-1个物品在容量为j-v[i](当前最大容量j减去当前物品的重量)的情况下的最大价值+当前物品的最大价值
					//两者取其最大值作为当前节点的价值
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
				}
			}
		}

		//3、输出最后一个节点的值：也就是N个背包在容量为V的限制下的最大价值
		System.out.println(dp[N][V]);

	}

}
