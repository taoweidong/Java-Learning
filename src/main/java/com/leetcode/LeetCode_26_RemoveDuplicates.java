package com.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * 26. 删除有序数组中的重复项
 */
public class LeetCode_26_RemoveDuplicates {
    public static void main(String[] args) {

        // int[] nums = {};
        int[] nums = {1, 1, 2, 2, 3};
        // int[] nums = {1, 3, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println("**********************");
        System.out.println(new LeetCode_26_RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (Objects.isNull(nums) || len == 0) {
            return 0;
        }

        int slow = 1;
        for (int fast = 1; fast < len; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                // 把非重复元素覆盖到重复元素的位置上去
                nums[slow] = nums[fast];
                // 调整慢指针的位置
                slow++;
            }
        }
        return slow;
    }
}
