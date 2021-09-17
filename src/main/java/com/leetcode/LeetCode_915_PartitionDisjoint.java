package com.leetcode;

/**
 * 915. 分割数组
 * 
 * @author Taoweidong
 */
public class LeetCode_915_PartitionDisjoint {
    public static void main(String[] args) {
        // int[] nums = {5, 0, 3, 8, 6};
        // int[] nums = {1, 1, 1, 0, 6, 12};
        // int[] nums = {1, 2, 3, 4, 6};
        int[] nums = {1, 1};
        System.out.println(new LeetCode_915_PartitionDisjoint().partitionDisjoint(nums));
    }

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        int m = nums[0];
        for (int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
            maxLeft[i] = m;
        }
        m = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            m = Math.min(m, nums[i]);
            minRight[i] = m;
        }
        for (int i = 1; i < n; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return 1;
    }

    public int partitionDisjoint2(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int maxValue = nums[0];
        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, nums[i - 1]);
            max[i - 1] = Math.max(maxValue, max[i - 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (max[i + 1] > max[i]) {
                return i + 1;
            }
        }
        return 1;
    }
}
