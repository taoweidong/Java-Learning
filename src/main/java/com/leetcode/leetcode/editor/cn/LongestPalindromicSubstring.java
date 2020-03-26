//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

package com.leetcode.leetcode.editor.cn;

/**
 * 最长回文子串
 * @author Taoweidong
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		Solution solution = new LongestPalindromicSubstring().new Solution();
		System.out.println(solution.longestPalindrome("abcba"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public String longestPalindrome(String s) {

			if (s.length() == 1) {
				return s;
			}

			//回文子串的长度
			int max = 0;
			//回文子串的内容
			String subStrMax = "";

			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j <= s.length(); j++) {
					//表示每一个子串
					String subStr = s.substring(i, j);
					if (isHuiWen(subStr) && subStr.length() > max) {
						subStrMax = s.substring(i, j);
						max = Math.max(subStrMax.length(), max);
					}
				}
			}

			return subStrMax;
		}

		/**
		 * 判断是否为回文子串
		 * @param str 待判断的字符串
		 * @return ture:表示是回文字符串
		 */
		public boolean isHuiWen(String str) {

			int length = str.length();
			for (int i = 0; i < length / 2; i++) {
				if (str.charAt(i) != str.charAt(length - i - 1)) {
					return false;
				}
			}

			return true;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}