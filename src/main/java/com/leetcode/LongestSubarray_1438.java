package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 绝对差不超过限制的最长连续子数组:https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 */
public class LongestSubarray_1438 {
    public static void main(String[] args) {

        LongestSubarray_1438 longestSubarray_1438 = new LongestSubarray_1438();
        int[] nums = {10, 1, 2, 4, 7, 2};
        int limit = 5;
        System.out.println(longestSubarray_1438.longestSubarray(nums, limit));


    }

    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //窗口内的最大值
        int windows_max = nums[0];
        //窗口内的最小值
        int windows_min = nums[0];

        Queue<Integer> windows_nums = new LinkedList<>();

        for (int item : nums) {
            //该窗口内的数据满足条件
            if (Math.abs(item - windows_max) <= limit && Math.abs(item - windows_min) <= limit
                    && Math.abs(windows_min - windows_max) <= limit) {
                windows_max = Math.max(item, windows_max);
                windows_min = Math.min(item, windows_min);
                //把当前元素添加到窗口记录中
                windows_nums.offer(item);
            } else {
                windows_nums.offer(item);
                //把最左边的元素出队列
                windows_nums.poll();
                //更新最大最小值
                windows_max = Collections.max(windows_nums);
                windows_min = Collections.min(windows_nums);
            }
        }

        return windows_nums.size();
    }
}
