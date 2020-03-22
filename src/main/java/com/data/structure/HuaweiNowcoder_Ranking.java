package com.data.structure;

import java.util.Scanner;

/**
 * @author Taoweidong
 */
public class HuaweiNowcoder_Ranking {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//总人数
			int num = sc.nextInt();
			if (num == 2) {
				System.out.println(0);
			}

			//存储每个数据元素
			int[] member = new int[num];
			//数据元素从左到右对应的最大递增子序列
			int[] left_member = new int[num];
			//数据元素从右往左对应的最大递增子序列
			int[] right_member = new int[num];

			String[] str = sc.nextLine().split(" ");
			for (int i = 0; i < str.length; i++) {
				member[i] = Integer.parseInt(str[i]);
				left_member[i] = 1;
				right_member[i] = 1;
			}

			for (int i = 0; i < num; i++) {
				for (int j = 0; j < i; j++) {
					if (member[i] > member[j] && left_member[j + 1] > left_member[i]) {
						left_member[i] = left_member[j] + 1;
					}
				}
			}

		}
	}
}
