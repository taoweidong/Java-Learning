package com.leetcode;

import java.util.*;

/**
 * 523. 连续的子数组和
 */
public class LeetCode_523_CheckSubarraySum {
    public static void main(String[] args) {
        // int[] nums = {23, 2, 4, 6, 7};
        // int k = 6;

        int[] nums = {23, 2, 6, 4, 7};
        int k = 13;

        // int[] nums = {5, 0, 0, 0};
        // int k = 3;
        System.out.println(new LeetCode_523_CheckSubarraySum().checkSubarraySum(nums, k));

    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (Objects.isNull(nums) || len < 2) {
            return false;
        }
        // key 前缀和与k的余数，如果再次遇到相同的值，检查索引距离>=2时即可
        // value 索引值
        Map<Integer, Integer> map = new HashMap<>(len);
        // 因为题目中说明了0 始终视为 k 的一个倍数，所以此处初始化位置1的前缀和时应该设置一个绝对不可能相等的值
        map.put(0, -1);
        // 计算前缀和
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }

    /**
     * 前缀和+同余定理 解法 满足条件
     * 
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum3(int[] nums, int k) {
        int len = nums.length;
        if (Objects.isNull(nums) || len < 2) {
            return false;
        }
        // 计算前缀和
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        Set<Integer> map = new HashSet<>();
        for (int i = 2; i <= len; i++) {
            map.add(preSum[i - 2] % k);
            if (map.contains(preSum[i] % k)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 前缀和优化第一版，暴力解法，超时
     * 
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int len = nums.length;
        if (Objects.isNull(nums) || len < 2) {
            return false;
        }

        // 计算前缀和
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 遍历数组处理
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 2; j <= len; j++) {
                if ((preSum[j] - preSum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
