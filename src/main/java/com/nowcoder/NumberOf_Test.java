package com.nowcoder;

/**
 * @author Taowd
 * @date 2018/5/26 - 13:09
 * @Description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf_Test {

    public static void main(String[] args) {

        String temp = Integer.toBinaryString(10);
        System.out.println(temp);

        System.out.println(NumberOf1(10));

    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int result = 0;
        String temp = Integer.toBinaryString(n);
        char[] data = temp.toCharArray();

        for (char item : data) {
            if (item == '1') {
                result++;
            }
        }
        return result;
    }

}
