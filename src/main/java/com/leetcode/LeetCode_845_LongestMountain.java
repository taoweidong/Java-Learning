package com.leetcode;

/**
 * 845. 数组中的最长山脉
 */
public class LeetCode_845_LongestMountain {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 7, 3, 2, 5};
        // int[] arr = {2, 2, 2};
        // int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(new LeetCode_845_LongestMountain().longestMountain(arr));

    }

    public int longestMountain(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return 0;
        }

        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[len];
        for (int i = len - 2; i >= 0; --i) {
            right[i] = arr[i + 1] < arr[i] ? right[i + 1] + 1 : 0;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] > 0 && right[i] > 0) {
                result = Math.max(result, left[i] + right[i] + 1);
            }
        }

        return result;
    }

    public int longestMountain2(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return 0;
        }

        int result = 0;
        int index = 1;
        while (index < len - 1) {
            int current = index + 1;
            // 满足山顶的特点
            if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) {
                // 中心的长度: 山顶+紧邻的左右两个
                int cnt = 3;

                // 向左找最大的长度
                current = index - 1;
                while (current > 0) {
                    if (arr[current] <= arr[current - 1]) {
                        break;
                    }
                    cnt++;
                    current--;
                }

                // 向右找满足条件的最大长度
                current = index + 1;
                while (current < len - 1) {
                    if (arr[current] <= arr[current + 1]) {
                        break;
                    }
                    cnt++;
                    current++;
                }
                result = Math.max(cnt, result);
            }
            // 更新起点到山的右边山脚下
            index = current;
        }

        return result;
    }
}
