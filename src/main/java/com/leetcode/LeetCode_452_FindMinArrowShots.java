package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class LeetCode_452_FindMinArrowShots {
    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // 排序: 按照开始时间
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                // 说明是重叠的，可以射中
                count++;
            } else {
                // 设置右边区间
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }

        return count;
    }
}
