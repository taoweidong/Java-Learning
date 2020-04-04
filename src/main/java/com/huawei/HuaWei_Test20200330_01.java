package com.huawei;

import java.util.Scanner;

/**
 * 跳跃比赛
 * @author Taoweidong
 */
public class HuaWei_Test20200330_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//输入参数
			String[] input = sc.nextLine().split(" ");
			int[] arr = new int[input.length];
			//处理输入数据
			for (int i = 0; i < input.length; i++) {
				arr[i] = Integer.valueOf(input[i]);
			}

			//进行正式逻辑处理
			int end = 0;
			int maxPosition = 0;
			int step = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				//找到能跳的最远的
				maxPosition = Math.max(maxPosition, arr[i] + i);
				if (i == end) {
					//如果遇到边界，就更新一下，并且步数加1
					end = maxPosition;
					step++;

				}
			}
			System.out.println(step);

		}
	}

}
