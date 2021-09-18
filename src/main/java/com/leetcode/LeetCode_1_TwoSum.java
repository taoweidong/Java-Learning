package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[] {hashTable.get(target - nums[i]), i};
            } else {
                hashTable.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
