package com.leetcode;

/***
 * 169. 多数元素
 */
public class LeetCode_169_MajorityElement {
    public int majorityElement(int[] nums) {
        int cand_flag = nums[0];
        int cand_count = 0;

        for (int item : nums) {
            if (item == cand_flag) {
                cand_count++;
            } else {
                cand_count--;
            }

            if (cand_count == 0) {
                cand_flag = item;
                cand_count = 1;
            }
        }

        return cand_flag;
    }
}
