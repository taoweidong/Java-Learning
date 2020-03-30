package com.data.structure;

import java.util.Scanner;

/**
 * 寻找最长连续子串
 * 给定一串字符，里面有些字符有连续出现的特点，请寻找这些连续出现字符中最长的串，
 * 如果最长的串有多个，请输出字符ASCII码最小的那一串
 * @author Taoweidong
 */
public class HuaWei_Test20200329_03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//输入参数
			String input = sc.nextLine();

			//最长连续子串的起始位置
			int start = 0;
			//最长连续子串的长度
			int maxLength = 0;
			for (int i = 0, j = i + 1; i < input.length(); i++) {
				if (input.charAt(i) == input.charAt(j)) {
					j++;
				} else {

				}
			}

		}
	}

}
