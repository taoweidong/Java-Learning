package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮:https://leetcode-cn.com/problems/fruit-into-baskets/<br/>
 * 求只包含两种元素的最长子序列
 */
public class LeetCode_904_TotalFruit {
    public static void main(String[] args) {
        // int[] fruits = {1, 2, 1};
        // int[] fruits = {0, 1, 2, 2};
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(new LeetCode_904_TotalFruit().totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;

        Map<Integer, Integer> windows = new HashMap<>(fruits.length);
        int result = 0;
        while (right < fruits.length) {
            windows.put(fruits[right], windows.getOrDefault(fruits[right], 0) + 1);
            right++;
            // 检查窗口是否满足条件
            while (windows.size() > 2) {
                int count = windows.getOrDefault(fruits[left], 0) - 1;
                if (count > 0) {
                    windows.put(fruits[left], count);
                } else {
                    windows.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left);
        }

        return result;
    }
}
