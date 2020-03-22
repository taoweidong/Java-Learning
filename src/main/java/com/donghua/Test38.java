package com.donghua;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test38 {

	public static void main(String[] args) throws Exception {

		Map<String, Integer> result = statisticalWords("asdhajd");

		for (Map.Entry<String, Integer> item : result.entrySet()) {
			System.out.printf("字符%s出现的个数为:%d\n", item.getKey(), item.getValue());
		}

	}

	/**
	 * 统计单词word中各个字符出现的个数
	 * @param word 待统计的单词
	 * @return 统计结果
	 */
	public static Map<String, Integer> statisticalWords(String word) {

		char[] words = Objects.toString(word, "").toLowerCase().toCharArray();

		Map<String, Integer> result = new HashMap<>(words.length);

		for (int i = 0; i < words.length; i++) {
			String temp = String.valueOf(words[i]);
			int count = result.getOrDefault(temp, 0);
			if (count == 0) {
				result.put(temp, 1);
			} else {
				result.put(temp, count + 1);
			}
		}

		return result;

	}

}
