package com.huawei.oo;

import java.util.*;

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
 * <p>
 * 容易理解，但是会超时的一种解法
 * https://leetcode-cn.com/problems/permutation-sequence/
 */
public class Huawei_20200603_01 {

    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] arr = in.nextLine().trim().split(" ");
            int n = Integer.valueOf(arr[0]);
            int k = Integer.valueOf(arr[1]);

            //进行逻辑处理
            System.out.println(getPermutation(n, k));
        }


    }

    /**
     * 获取指定数组元素的全排列结果
     *
     * @param num 待处理数组
     * @return 全排列结果
     */
    private static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }


    /**
     * 第k个排列:给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * 给定 n 和 k，返回第 k 个排列。
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {

        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        //进行组合
        ArrayList<ArrayList<Integer>> result = permute(arr);

        //进行降序排列
        List<Integer> queue = new ArrayList<>();
        for (ArrayList item : result) {

            StringBuffer temp = new StringBuffer(item.size());
            item.forEach(x -> temp.append(x));

            queue.add(Integer.valueOf(temp.toString()));
        }

        Collections.sort(queue);

        //输出结果
        return String.valueOf(queue.get(k - 1));
    }


}
