package com.leetcode;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 */
public class LeetCode_1109_CorpFlightBookings {
    public static void main(String[] args) {

        // int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        // int n = 5;

        int[][] bookings = {{1, 2, 10}, {2, 2, 15}};
        int n = 2;
        int[] result = new LeetCode_1109_CorpFlightBookings().corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(result));

    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                result[i - 1] += booking[2];
            }
        }
        return result;
    }
}
