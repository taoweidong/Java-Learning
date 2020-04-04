package com.data.structure;

import com.alibaba.fastjson.JSON;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 栈相关方法熟悉：先进后出
 *
 * @author Taoweidong
 */
public class StackDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(100, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        priorityQueue.add(9);
        priorityQueue.add(3);
        priorityQueue.add(255);
        priorityQueue.add(5);


        while (!priorityQueue.isEmpty()) {                        //调用poll方法时候会进行比较；
            System.out.println(priorityQueue.poll()); //直接在这里打印会报错类型不对，因为比较对象要实现comparable接口并且实
        }

//        System.out.println(JSON.toJSONString(priorityQueue));

    }
}
