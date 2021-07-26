package com.leetcode;

import java.util.Arrays;

public class LeetCode_80_RemoveDuplicates {
    public static void main(String[] args) {
        // int[] nums = {};
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 2, 3};
        // int[] nums = {1, 3, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println("**********************");
        System.out.println(new LeetCode_80_RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        int slow = 2;
        for (int fast = 2; fast < len; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
