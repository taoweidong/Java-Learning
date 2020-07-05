package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最小覆盖子串:https://leetcode-cn.com/problems/minimum-window-substring/
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路解析：https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABCC"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "aa"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "b"));
        System.out.println(new MinimumWindowSubstring().minWindow("aa", "aa"));
    }

    public String minWindow(String s, String t) {
        //考虑异常情形
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        //最终字符串的信息：开始位置 和 最小长度
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        //定义双指针
        int left = 0;
        int right = 0;

        //需要统计的字符个数
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        //当前窗口中包含的字符信息
        Map<Character, Integer> windows = new LinkedHashMap<>();

        int match = 0;
        //开始双指针操作
        while (right < s.length()) {
            char s1 = s.charAt(right);
            windows.put(s1, windows.getOrDefault(s1, 0) + 1);
            if (needs.containsKey(s1)) {
                //注意点1：
                if (needs.get(s1) > 0 && windows.get(s1) <= needs.get(s1)) {
                    //字符s1出现次数已经满足条件
                    match++;
                }
            }
            //windows中的字符串已经符合needs的要求了
            //判断左侧窗口是否要收缩
            while (t.length() == match) {
                // 在这里更新最小覆盖子串
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }

                //窗口内数据更新
                char l1 = s.charAt(left);
                if (needs.containsKey(l1)) {
                    if (needs.get(l1) > 0 && windows.get(l1) <= needs.get(l1)) {
                        //字符l1出现的次数不满足条件
                        match--;
                    }
                }
                //从左边移除一个字符
                windows.put(l1, windows.getOrDefault(l1, 0) - 1);
                left++;
            }
            right++;
        }

        //处理特殊情况：当t在s中找不到的满足条件的字符串时，返回为空
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
