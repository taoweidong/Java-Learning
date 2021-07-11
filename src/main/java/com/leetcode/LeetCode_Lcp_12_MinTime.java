package com.leetcode;

import java.util.Arrays;

/**
 * LCP 12. 小张刷题计划
 */
public class LeetCode_Lcp_12_MinTime {
    public static void main(String[] args) {
        int[] time = {1, 2, 3, 3};
        int m = 2;

        // int[] time = {999, 999, 999};
        // int m = 4;
        System.out.println(new LeetCode_Lcp_12_MinTime().minTime(time, m));

    }

    public int minTime(int[] time, int m) {
        int left = 0;
        int right = Arrays.stream(time).sum();

        while (left < right) {
            int mid = (left + right) / 2;
            // 每天最多使用mid时间，m天可以完成吗？
            if (check(mid, time, m)) {
                // 调整左区间
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int limit, int[] time, int m) {
        // 任务执行完需要的总天数
        int sum_day = 1;
        // 当天任务执行完需要的总时间
        int sum_time = 0;
        // 当天最耗时的题目
        int max_time = time[0];

        for (int i = 1; i < time.length; i++) {
            if (sum_time + Math.min(max_time, time[i]) <= limit) {
                // 计算任务总耗时
                sum_time += Math.min(max_time, time[i]);
                // 更新任务的最大值
                max_time = Math.max(max_time, time[i]);
            } else {
                // 新的一天：
                // 天数加1
                sum_day++;
                // 当天任务执行的总时间
                sum_time = 0;
                // 当天任务执行的最耗时的时间
                max_time = time[i];
            }

        }

        return sum_day <= m;
    }
}
