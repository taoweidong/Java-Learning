// 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
// 输出: "bab"
// 注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
// 输出: "bb"
//
// Related Topics 字符串 动态规划

package com.leetcode;

/**
 * 最长回文子串
 * 
 * @author Taoweidong
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abcba"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {

            if (s == null || s.length() == 1) {
                return s;
            }

            String result = "";
            for (int i = 0; i < s.length(); i++) {
                // 以i为中心的最长回文子串
                String str = palindrome(s, i, i);
                // 以i和i+1为中心的最长回文子串
                String str2 = palindrome(s, i, i + 1);

                result = result.length() > str.length() ? result : str;
                result = result.length() > str2.length() ? result : str2;

            }

            return result;
        }

        /**
         * 判断是否为回文子串
         * 
         * @param str
         *            待判断的字符串
         * @param left
         *            中心左边
         * @param right
         *            中心右边
         * @return 回文串
         */
        public String palindrome(String str, int left, int right) {
            // 中心扩散法
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                // 如果中心两边的字符相同，则进行位置移动，继续检查下一位
                left--;
                right++;
            }

            return str.substring(left + 1, right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}