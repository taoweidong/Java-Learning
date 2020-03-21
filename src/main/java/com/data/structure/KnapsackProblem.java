package com.data.structure;

/**
 * 动态规划-背包问题
 * @author Taoweidong
 */
public class KnapsackProblem {

	public static void main(String[] args) {

		//物品的重量
		int[] w = { 1, 4, 3 };
		//物品的价值
		int[] value = { 1500, 3000, 2000 };
		//背包的最大容量
		int m = 4;
		//物品的个数
		int n = value.length;

		//创建动态规划分布表
		int[][] v = new int[n + 1][m + 1];
		//初始化分布表
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		for (int j = 0; j < v[0].length; j++) {
			v[0][j] = 0;
		}

		//开始进行动态规划
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[i].length; j++) {
				//如果新增的商品大于当前背包容量j的话，就无法放入背包，则当前的价值仍然为前i-1个商品的价值
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					//否则，新增的商品容量小于当前背包容量j，则说明可以添加到背包中
					v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - w[i - 1]]);
				}
			}

		}

		int maxValue = 0;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[0].length; j++) {
				maxValue = Math.max(maxValue, v[i][j]);
				System.out.print(v[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("结果：" + maxValue);

	}

}
