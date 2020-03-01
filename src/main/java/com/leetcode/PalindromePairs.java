// 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
//
// 示例 1:
//
// 输入: ["abcd","dcba","lls","s","sssll"]
// 输出: [[0,1],[1,0],[3,2],[2,4]]
// 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
//
//
// 示例 2:
//
// 输入: ["bat","tab","cat"]
// 输出: [[0,1],[1,0]]
// 解释: 可拼接成的回文串为 ["battab","tabbat"]
// Related Topics 字典树 哈希表 字符串

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 回文对
 * @author Taoweidong
 */
public class PalindromePairs {

	public static void main(String[] args) {

		Solution solution = new PalindromePairs().new Solution();
		String[] inputStr = { "abcd", "dcba", "lls", "s", "sssll" };
		System.out.println(JSON.toJSONString(solution.palindromePairs(inputStr)));
	}

	// leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public List<List<Integer>> palindromePairs(String[] words) {

			List<List<Integer>> result = new ArrayList<>();
			int wordLength = words.length;

			for (int i = 0; i < wordLength; i++) {
				for (int j = 0; j < wordLength; j++) {
					if (i == j) {
						continue;
					} else {
						// 检查拼接起来是不是回文字符串
						if (isCheck(words[i] + words[j])) {
							List<Integer> item = new ArrayList<>();
							item.add(i);
							item.add(j);
							result.add(item);
						}
					}
				}
			}

			return result;
		}

		/**
		 * 检查字符串是否为回文字符串
		 * @param s 待检查的字符串
		 * @return 检查结果 True:是 False:否
		 */
		private boolean isCheck(String s) {

			int start = 0;
			int end = s.length() - 1;
			while (start < end) {
				if (s.charAt(start) != s.charAt(end)) {
					return false;
				}
				start++;
				end--;
			}
			return true;
		}
	}
	// leetcode submit region end(Prohibit modification and deletion)

}
