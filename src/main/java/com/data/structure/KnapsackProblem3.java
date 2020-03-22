package com.data.structure;

/**
 * 动态规划-背包问题2-优化版本，记录详细信息
 * @author Taoweidong
 */
public class KnapsackProblem3 {

	public static void main(String[] args) {

		//物品的重量
		int[] w = { 1, 2, 3, 4 };
		//物品的价值
		int[] value = { 2, 4, 4, 5 };
		//背包的最大容量
		int m = 5;
		int y = m;
		//物品的个数
		int n = value.length;

		int[] z = new int[y];
		//创建动态规划分布表
		int[][][] v = new int[n + 1][m + 1][y + 1];
		//初始化分布表

		for (int i = 0; i < v.length; i++) {
			v[i][0][0] = 0;
		}
		for (int j = 0; j < v[0].length; j++) {
			v[0][j][0] = 0;
		}
		for (int u = 0; u < v[0][0].length; u++) {
			v[0][0][u] = 0;
		}

		//创建动态规划分布表
		int[][] path = new int[n + 1][m + 1];

		//开始进行动态规划
		System.out.printf("%d,%d,%d\n", v.length, v[0].length, y);
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[i].length; j++) {

				//如果新增的商品大于当前背包容量j的话，就无法放入背包，则当前的价值仍然为前i-1个商品的价值
				for (int x = 0; x < y + 1; x++) {
					if (0 == x) {
						v[i][j][x] = v[i - 1][j][y];
					} else {
						if (w[i - 1] * x > j) {
							v[i][j][x] = v[i][j][x - 1];
						} else {
							System.out.printf("进入算法\n");
							if (v[i - 1][j][y] < value[i - 1] * x + v[i - 1][j - w[i - 1] * x][y]) {
								System.out.printf("%d\n", v[i - 1][j - w[i - 1] * x][y]);
								v[i][j][x] = value[i - 1] * x + v[i - 1][j - w[i - 1] * x][y];
							} else {
								System.out.printf("%d\n", x);
								v[i][j][x] = v[i][j][x - 1];
							}

						}
					}
					System.out.printf("%d,%d，%d\n", i, j, x);
					System.out.printf("%d\n", v[i][j][x]);
				}
			}

		}
		System.out.printf("最大的价值：%d", v[n][m][y]);
	}

}
