package com.leetcode;

import java.util.Arrays;

public class LeetCode_881_NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        // 先按照大小排序
        Arrays.sort(people);
        // 收集结果
        int result = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            result++;
            int num = people[left] + people[right];
            if (num <= limit) {
                left++;
            }
            right--;
        }

        return result;
    }
}
