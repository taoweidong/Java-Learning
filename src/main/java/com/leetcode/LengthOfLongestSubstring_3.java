package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 3. 无重复字符的最长子串:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/ 给定一个字符串，请你找出其中不含有重复字符的
 * 最长子串 的长度。 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {

        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring2("bbbbb"));
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring2("pwwkew"));
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring2(""));
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring2("a"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 定义左右指针
        // int left = 0;
        // int right = 0;
        // 定义存放窗口中的数据
        Queue<Character> windows = new LinkedList<>();
        // 存放最终结果
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Character item = s.charAt(i);
            if (windows.contains(item)) {
                result = Math.max(windows.size(), result);
            }

            // 检查窗口是否满足条件
            while (windows.contains(item)) {
                // 移除窗口中的最左侧元素
                windows.poll();
            }

            // 先将数据存放到窗口中
            windows.add(item);

        }
        return Math.max(windows.size(), result);
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 定义左右指针
        int left = 0;
        int right = 0;
        // 定义存放窗口中的数据
        Map<Character, Integer> windows = new HashMap<>(s.length());
        // 存放最终结果
        int result = 0;

        // 滑动窗口
        while (right < s.length()) {
            char item = s.charAt(right);
            windows.put(item, windows.getOrDefault(item, 0) + 1);
            right++;

            // 检查窗口是否不满足条件，然后开始滑动左边窗口
            while (windows.get(item) > 1) {
                char c2 = s.charAt(left);
                windows.put(c2, windows.getOrDefault(c2, 0) - 1);
                left++;
            }
            result = Math.max(result, right - left);

        }
        return result;
    }
}
