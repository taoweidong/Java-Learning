package com.data.structure;

import java.util.HashMap;
import java.util.Map;
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

			Map<Character, Integer> map = new HashMap<>(input.length());

			for (int i = 0; i < input.length(); i++) {
				int count = 0;
				if (map.containsKey(input.charAt(i))) {
					//如果当前字符已经在集合中存在了
					count = map.get(input.charAt(i));
				}

				for (int j = i + 1; j < input.length(); j++) {

					if (count != 0) {

						map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);

					} else {
						map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
					}

					if (input.charAt(i) == input.charAt(j)) {

					} else {
						i = j;
					}
				}
			}

		}
	}

}
