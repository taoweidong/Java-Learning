package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author Taoweidong
 */
public class SubarraySum560 {
    public static void main(String[] args) {
        //
    }

    public int subarraySum(int[] nums, int k) {

        // 用于统计和为k的个数
        Map<Integer, Integer> map = new HashMap<>(k);
        map.put(0, 1);

        int result = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }
            // 更新个数
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return result;
    }
}
