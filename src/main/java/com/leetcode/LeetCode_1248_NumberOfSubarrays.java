package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode_1248_NumberOfSubarrays {
    public static void main(String[] args) {

    }

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        if (Objects.isNull(nums) || len == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(len);
        map.put(0, 1);

        int result = 0;
        // 统计奇数的个数
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 != 0) {
                // 奇数
                count++;
            }
            if (map.containsKey(count - k)) {
                result += map.get(count - k);
            }

            map.put(count, map.getOrDefault(count, 0) + 1);
        }

        return result;
    }
}
