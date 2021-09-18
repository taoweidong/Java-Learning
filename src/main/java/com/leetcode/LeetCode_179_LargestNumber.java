package com.leetcode;

import java.util.Arrays;

/**
 * 179. 最大数
 */
public class LeetCode_179_LargestNumber {
    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};
        // int[] nums = {10, 2};
        // int[] nums = {1};
        // int[] nums = {0, 0, 0,};
        // int[] nums = {1, 2, 3};
        // int[] nums = {1, 1, 1};
        // int[] nums = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(new LeetCode_179_LargestNumber().largestNumber(nums));

    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 排序
        Arrays.sort(strs, (x, y) -> {
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy);
        });

        StringBuilder sb = new StringBuilder(n);
        for (String item : strs) {
            sb.append(item);
        }

        String result = sb.toString();
        while (result.startsWith("0")) {
            result = result.substring(1);
        }

        if ("".equals(result)) {
            return "0";
        }

        return result;
    }
}
