package com.leetcode;

/**
 * 27. 移除元素
 */
public class LeetCode_27_RemoveElement {
    public static void main(String[] args) {
        // int[] nums = {3, 2, 2, 3};
        // int[] nums = {3};
        // int[] nums = {};
        int[] nums = {1, 2, 3, 4, 5, 6};
        int val = 3;
        System.out.println(new LeetCode_27_RemoveElement().removeElement(nums, val));

    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
