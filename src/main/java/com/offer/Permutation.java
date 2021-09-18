package com.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 排列组合一个字符串:给一个字符串，比如ABC， 把所有的排列，即：ABC, ACB, BAC, BCA, CAB, CBC 都找出来。
 * https://blog.csdn.net/HelloZEX/article/details/81178615 解题思路(回溯方法递归调用)：对于一个n 位的字符串来讲，它是n-1位字符串的排列 加上 没有在 n -1 位字符串里
 * 那个字符 的排列。
 */
public class Permutation {

    private static Set<String> resultSet = new HashSet<>();

    public static void main(String[] args) {

        permutation("ABCD", "");

        for (String s : resultSet) {
            System.out.println(s);
        }
    }

    /**
     * 排列组合一个字符串:给一个字符串，比如ABC， 把所有的排列，即：ABC, ACB, BAC, BCA, CAB, CBC 都找出来。
     *
     * @param S
     *            待排序的字符串
     * @return 排序好的字符串结果
     */
    public String[] permutation(String S) {
        permutation(S, "");
        String[] strings = new String[resultSet.size()];
        return resultSet.toArray(strings);
    }

    /**
     * 解题思路：(回溯方法递归调用)：对于一个n 位的字符串来讲，它是n-1位字符串的排列 加上 没有在 n -1 位字符串里 那个字符 的排列。
     * 理解：回溯时每一次的处理结果都作为下次迭代的入参，迭代到最后一层时，就是本地迭代的结果，记录下来
     *
     * @param origin
     *            原始字符串
     * @param result
     *            组合结果
     */
    private static void permutation(String origin, String result) {
        int len = origin.length();
        // 递归的退出条件
        if (len == 1) {
            resultSet.add(result + origin);
            return;
        }

        for (int i = 0; i < len; i++) {

            // 直到本次迭代时已经排好的序列
            StringBuffer str = new StringBuffer(result);
            str.append(origin.charAt(i));

            // 把当前字符去掉，继续递归下一个组合
            String temp = origin.replaceAll(origin.charAt(i) + "", "");

            // 继续递归下一个组合
            permutation(temp, str.toString());

        }
    }
}
