package com.leetcode;

/**
 * 编程题：有n步台阶，一次只能上1步或者2步，共有多少种走法
 *
 * @author taowd
 */
public class TestStep {

    public static void main(String[] args) {

        System.out.println(new TestStep().f(1));
        System.out.println(new TestStep().f(2));
        System.out.println(new TestStep().f(3));
        System.out.println(new TestStep().f(30));

        System.out.println(new TestStep().loop(1));
        System.out.println(new TestStep().loop(2));
        System.out.println(new TestStep().loop(3));
        System.out.println(new TestStep().loop(30));
    }

    /**
     * 优点：大问题转换为小问题，可以减少代码量，同时代码精简，可读性好 缺点：递归调用浪费空间，而且递归太深容易造成堆栈的溢出
     *
     * @param n
     *            台阶总数
     * @return 走法总数
     */
    public int f(int n) {

        if (n < 1) {
            throw new IllegalArgumentException("非法参数异常");
        }

        if (n == 1 || n == 2) {
            return n;
        }

        return f(n - 2) + f(n - 1);
    }

    /**
     * 优点：代码效率高，因为时间只因循环次数增加而增加，而且没有额外的空间开销 缺点：代码不如递归简介，可读性差
     *
     * @param n
     *            台阶总数
     * @return 走法总数
     */
    public int loop(int n) {

        if (n < 1) {
            throw new IllegalArgumentException("非法参数异常");
        }

        if (n == 1 || n == 2) {
            return n;
        }

        // 初始化为走到第二级台阶的走法
        int one = 2;
        // 初始化为走到第一级台阶的走法
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            // 最后跨2步 + 最后跨1步的走法
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}
