package com.data.structure;

import com.alibaba.fastjson.JSON;

import java.util.Scanner;

/**
 * @author Taoweidong
 */
public class TestGuaWei {

	public static void main(String[] args) {

		// 读入数据的代码
		Scanner reader = new Scanner(System.in);
		// 物品的数量为N
		int N = reader.nextInt();
		// 背包的容量为V
		int V = reader.nextInt();
		// 一个长度为N的数组，第i个元素表示第i个物品的体积；
		int[] v = new int[N + 1];
		// 一个长度为N的数组，第i个元素表示第i个物品的价值；
		int[] w = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			// 接下来有 N 行，每行有两个整数:v[i],w[i]，用空格隔开，分别表示第i件物品的体积和价值
			v[i] = reader.nextInt();
			w[i] = reader.nextInt();
		}
		reader.close();

		System.out.println(JSON.toJSONString(v));
		System.out.println(JSON.toJSONString(w));

	}
}
