package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 560. 和为K的子数组
 */
public class LeetCode_560_SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new LeetCode_560_SubarraySum().subarraySum(nums, k));

        // int[] nums = {1, 2, 3, 2};
        // int k = 5;
        // System.out.println(new LeetCode_560_SubarraySum().subarraySum(nums, k));

    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        // 卫语句处理异常
        if (Objects.isNull(nums) || len == 0) {
            return 0;
        }

        // 在计算前缀和的时候，把满足条件的子区间记录下来
        Map<Integer, Integer> preMap = new HashMap<>(len);
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (preMap.containsKey(sum - k)) {
                result += preMap.get(sum - k);
            }
            preMap.put(sum, preMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    /**
     * 前缀和优化第一版
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        // 卫语句处理异常
        if (Objects.isNull(nums) || len == 0) {
            return 0;
        }
        // 计算出前缀和
        int[] preSum = new int[len + 1];
        // 注意此处的处理，增加一位作为预处理
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 计算和位k的子数组
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    result++;
                }
            }
        }

        return result;
    }

    /***
     * 暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        // 卫语句处理异常
        if (Objects.isNull(nums) || len == 0) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // 如果i-j这一段子数组中的和位k,则满足条件
                if (sum(nums, i, j) == k) {
                    result++;
                }
            }
        }
        return result;
    }

    private int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
