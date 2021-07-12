package com.basic.grammar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Float进行运算时出现错误的情况分析<br/>
 * 浮点数在内存中是按照IEEE754标准进行存储的。 计算机内部是通过二进制也就是0和1来存储数据的，浮点数也不例外，但是有些浮点数是无法精确存储的，只有由2的幂组成的数才可以精确存储。 2.0f在内存中可以准确的存储：<br/>
 * 解决方法：通过java.math包中提供的BigDecimal类可以解决此类问题 參考：https://blog.csdn.net/cflys/article/details/70768110
 *
 * @author taowd
 * @version 2019年5月7日
 * @see StackDemo
 */
public class StackDemo {

    public static void main(String[] args) {

        // 栈：先进后出的数据结构
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(null);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("*");

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(null);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
