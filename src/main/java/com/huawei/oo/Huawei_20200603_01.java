package com.huawei.oo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 第k个排列:给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class Huawei_20200603_01 {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));

    }


    public static String getPermutation(int n, int k) {

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        //进行组合
        getPermutation(0, 3, arr);

        String[] data = extractPermutationResult.toString().split("\\|");

        //进行降序排列
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (String item : data) {
            queue.add(Integer.valueOf(item.replace(",", "")));
        }

        //输出结果
        for (int i = 0; i < k; i++) {
            queue.poll();
        }
        return String.valueOf(queue.peek());
    }

    private static ArrayList<Integer> resultList = new ArrayList<>();
    //所有的组合方式以|分割
    private static StringBuffer extractPermutationResult = new StringBuffer();

    /**
     * 在给定数组arr中获取count个数的所有排列组合
     * 对标python中的itertools.combinations方法
     *
     * @param index 首个索引下标
     * @param count 每次取几个数
     * @param arr   给定数组
     * @return
     */
    public static void getPermutation(int index, int count, int[] arr) {
        if (count > arr.length || arr.length <= 0) {
            return;
        }

        if (arr.length == count) {
            for (int i = index; i < arr.length; i++) {
                extractPermutationResult.append(arr[i]).append(",");
            }
            return;
        }

        if (count == 1) {
            for (int i = index; i < arr.length; i++) {
                resultList.add(arr[i]);
                for (Integer item : resultList) {
                    extractPermutationResult.append(item).append(",");
                }
                extractPermutationResult.delete(extractPermutationResult.length() - 1, extractPermutationResult.length()).append("|");
//                System.out.println(resultList);
                resultList.remove((Object) arr[i]);
            }
        } else if (count > 1) {
            for (int i = index; i < arr.length - count; i++) {
                resultList.add(arr[i]);
                //递归的方式在数组arr中找count-1个数的组合
                getPermutation(i + 1, count - 1, arr);
                resultList.remove((Object) arr[i]);
            }
        } else {
            return;
        }
    }

}
