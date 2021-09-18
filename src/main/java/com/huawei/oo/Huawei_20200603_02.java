package com.huawei.oo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 第k个排列:给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123" "132" "213" "231" "312" "321" 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3 输出: "213"
 * <p>
 * <p>
 * 使用阶乘系统进行计算 https://leetcode-cn.com/problems/permutation-sequence/
 */
public class Huawei_20200603_02 {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] arr = in.nextLine().trim().split(" ");
            int n = Integer.valueOf(arr[0]);
            int k = Integer.valueOf(arr[1]);

            // 进行逻辑处理
            System.out.println(getPermutation(n, k));
        }
    }

    public static String getPermutation(int n, int k) {
        // 阶乘数
        int[] factorialNum = new int[n];
        // 把k转换为从0开始的下标
        k = k - 1;
        // 阶乘数的最低位必然为0
        factorialNum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            factorialNum[n - i - 1] = k % (i + 1);
            k /= i + 1;
        }
        // 从1到n的全部数字
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        // 把阶乘数转换为具体的排列
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 阶乘数的权重即为应当选取的数字的下标
            sb.append(nums.get(factorialNum[i]));
            // 移除已经用过的数字
            nums.remove(factorialNum[i]);
        }

        return sb.toString();
    }

}
