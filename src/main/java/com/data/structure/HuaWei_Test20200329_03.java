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
			String str = sc.nextLine();
			char[] chars = str.toCharArray();

			//最长连续子串的起始位置
			int start = 0;
			//最长连续子串的长度
			int maxLength = 0;
			for (int i = 0, j = 0; j < chars.length; j++) {

				if (j == 0) {
					maxLength = 1;
					continue;
				}

				//分界点时
				if (chars[j] != chars[j - 1]) {
					if (maxLength < j - i) {
						maxLength = j - i;
						start = i;

					}//题目中要求的，如果长度相同取ASCII比较小的那一串
					else if (maxLength == j - i && chars[start] > chars[j - 1]) {
						start = i;
					}
					i = j;
				}

				//处理后缀为最长连续子串的情况
				if (j == chars.length - 1) {
					if (maxLength < j - i + 1) {
						maxLength = j - i + 1;
						start = i;
					} else if (maxLength == j - i + 1 && chars[start] > chars[j]) {
						start = i;
					}

				}

			}

			System.out.println(str.substring(start, maxLength + start));

		}
	}

}
