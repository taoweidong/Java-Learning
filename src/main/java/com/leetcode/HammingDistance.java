package com.leetcode;

/**
 * 461. 汉明距离:https://leetcode-cn.com/problems/hamming-distance/ 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 给出两个整数 x 和
 * y，计算它们之间的汉明距离。
 */
public class HammingDistance {
    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(1 ^ 4));

        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);
    }
}
