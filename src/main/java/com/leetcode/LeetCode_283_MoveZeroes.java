package com.leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class LeetCode_283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new LeetCode_283_MoveZeroes().moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < len; i++) {
            nums[i] = 0;
        }
    }
}
