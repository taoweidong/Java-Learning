package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_3_LengthOfLongestSubstring {
  public static void main(String[] args) {

    System.out.println(
        new LeetCode_3_LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));

    System.out.println(new LeetCode_3_LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));

    System.out.println(
        new LeetCode_3_LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    int left = 0;
    int right = 0;

    int result = 0;

    // 定义窗口
    Map<Character, Integer> windows = new HashMap<>(s.length());

    while (right < s.length()) {
      char c1 = s.charAt(right);
      // 加入到窗口中
      windows.put(c1, windows.getOrDefault(c1, 0) + 1);
      // 移动右窗口
      right++;

      while (windows.getOrDefault(c1, 0) > 1) {
        char c2 = s.charAt(left);
        windows.put(c2, windows.getOrDefault(c2, 0) - 1);
        // 移动左窗口
        left++;
      }

      result = Math.max(result, right - left);
    }

    return result;
  }
}
