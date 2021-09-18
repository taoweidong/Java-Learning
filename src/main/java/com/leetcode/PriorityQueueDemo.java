package com.leetcode;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        // peek()//返回队首元素
        // poll()//返回队首元素，队首元素出队列
        // add()//添加元素
        // size()//返回队列元素个数
        // isEmpty()//判断队列是否为空，为空返回true,不空返回false

        // 默认使用升序排序，无需手动排序，内部实现使用小顶堆数据结构
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(12);
        queue.add(7);
        queue.add(45);
        queue.add(132);
        queue.add(3);

        System.out.println(queue);

        // 使用自定义构造器，实现降序排序
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((x, y) -> y - x);
        queue2.add(12);
        queue2.add(7);
        queue2.add(45);
        queue2.add(132);
        queue2.add(3);

        System.out.println(queue2.peek());
        System.out.println(queue2.remove());
        System.out.println(queue2);

    }

}
