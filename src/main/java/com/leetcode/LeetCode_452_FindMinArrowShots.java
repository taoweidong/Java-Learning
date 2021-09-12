package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class LeetCode_452_FindMinArrowShots {
    public static void main(String[] args) {
        // int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{5, 12}, {1, 4}, {3, 9}};
        System.out.println(new LeetCode_452_FindMinArrowShots().findMinArrowShots(points));
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
                // 区间不重叠，新增射箭数量，说明是重叠的，可以射中
                count++;
            } else {
                // 合并区间，设置右边区间
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }

        return count;
    }
}
