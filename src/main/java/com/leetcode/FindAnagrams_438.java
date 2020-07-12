package com.leetcode;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词:https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams_438 {

    public static void main(String[] args) {
        System.out.println(new FindAnagrams_438().findAnagrams("cbaebabacd", "abc"));
//        System.out.println(new FindAnagrams_438().findAnagrams("abab", "ab"));

    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return Collections.emptyList();
        }

        //定义左右指针
        int left = 0;
        int right = 0;

        //待查找数据
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        //窗口数据
        Map<Character, Integer> windows = new HashMap<>();

        //结果
        List<Integer> result = new ArrayList<>();

        int match = 0;

        //开始滑动窗口
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (windows.getOrDefault(c1, 0).equals(needs.get(c1))) {
                    match++;
                }
            }
            right++;

            //窗口内的数据是否满足条件
            while (match == needs.size()) {
                if (right - left == p.length()) {
                    result.add(left);
                }

                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.getOrDefault(c2, 0) - 1);
                    if (windows.getOrDefault(c2, 0) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return result;
    }
}
