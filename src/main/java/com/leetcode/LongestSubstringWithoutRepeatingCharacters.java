// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window

package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 
 * @author Taoweidong
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {

            if (s.length() <= 1) {
                return s.length();
            }

            // 给定字符串的长度
            int length = s.length();
            // 最长子串的长度
            int max = 0;

            // 遍历所有子串
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= length; j++) {
                    String str = s.substring(i, j);
                    if (isAllUnique(str)) {
                        max = Math.max(max, str.length());
                    }
                }
            }

            return max;
        }

        private boolean isAllUnique(String str) {

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}