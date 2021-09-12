package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 17.17. 多次搜索<br/>
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，<br/>
 * 设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。<br/>
 * <br/>
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 */
public class LeetCode_17_MultiSearch {
    public static void main(String[] args) {
        // 1、正常用例
        // String big = "mississippi";
        // String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};

        // 2、特殊用例：待搜索字符串为空的情况
        // String big = "mississippi";
        // String[] smalls = {""};

        // 3、特殊用例：原始字符串为空的情况
        // String big = "aaaaaaaaaaaaa";
        // String[] smalls = {"a", "aa", "aaa", "aaaa"};

        String big = "";
        String[] smalls = {"a", "aa", "aaa", "aaaa"};

        int[][] result = new LeetCode_17_MultiSearch().multiSearch(big, smalls);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public int[][] multiSearch(String big, String[] smalls) {
        int[][] result = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            result[i] = getSize(big, smalls[i]);
        }
        return result;
    }

    private int[] getSize(String big, String small) {
        List<Integer> result = new ArrayList<>();
        if ("".equals(small) || "".equals(big)) {
            return new int[0];
        }
        int index = big.indexOf(small, 0);
        if (index == -1) {
            return new int[0];
        }
        result.add(index);
        while (index >= 0) {
            index = big.indexOf(small, index + 1);
            if (index > -1) {
                result.add(index);
            }
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
