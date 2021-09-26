package com.leetcode;

/**
 * 1052. 爱生气的书店老板
 */
public class LeetCode_1052_MaxSatisfied {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;

        System.out.println(new LeetCode_1052_MaxSatisfied().maxSatisfied(customers, grumpy, minutes));

    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length = customers.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }

        int max = 0;
        int windows = 0;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (grumpy[right] == 1) {
                windows += customers[right];
            }
            right++;
            if (right - left > minutes) {
                if (grumpy[left] == 1) {
                    windows -= customers[left];
                }
                left++;
            }
            max = Math.max(windows, max);
        }

        return result + max;
    }
}
