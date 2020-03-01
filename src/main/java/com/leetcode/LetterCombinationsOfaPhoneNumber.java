// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
// 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
// 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 电话号码的字母组合
 * @author Taoweidong
 */
public class LetterCombinationsOfaPhoneNumber {

	public static void main(String[] args) {

		Solution solution = new LetterCombinationsOfaPhoneNumber().new Solution();
		System.out.println(JSON.toJSONString(solution.letterCombinations("2345")));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		Map<String, String> phone = new HashMap<String, String>() {

			{
				put("2", "abc");
				put("3", "def");
				put("4", "ghi");
				put("5", "jkl");
				put("6", "mno");
				put("7", "pqrs");
				put("8", "tuv");
				put("9", "wxyz");
			}
		};

		List<String> output = new ArrayList<>();

		public void backtrack(String combination, String nextDigits) {

			// 如果没有下一个数字，证明所有的排序序列已经找完，添加的输出集合里面，这里也是退出迭代的条件
			if (nextDigits.length() == 0) {
				output.add(combination);
			} else {
				// 获取下一个数字，进行迭代
				String digits = nextDigits.substring(0, 1);
				// 获取下一个数字对应的字符串
				String letters = phone.get(digits);

				for (int i = 0; i < letters.length(); i++) {
					// 通过截取的方式获取下一个字符串
					String letter = phone.get(digits).substring(i, i + 1);
					// 然后继续迭代找到下个字符串
					backtrack(combination + letter, nextDigits.substring(1));
				}

			}

		}

		public List<String> letterCombinations(String digits) {

			if (digits.length() != 0) {
				backtrack("", digits);
			}

			return output;
		}
	}
	// leetcode submit region end(Prohibit modification and deletion)

}