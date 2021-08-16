package com.java8;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Lambda 是一个 匿名函数，我们可以把 Lambda 表达式理解为是 一段可以传递的代码（将代码 像数据一样进行传递）。<br/>
 * 可以写出更简洁、更 灵活的代码。作为一种更紧凑的代码风格，使 Java的语言表达能力得到了提升。
 * 
 * @author Taowd
 * @date 2018年12月19日 <br/>
 *       左侧：参数列表<br/>
 *       右侧：方法的具体实现,所执行的具体功能<br/>
 */
@SuppressWarnings("unused")
public class Lambda2 {

    public static void main(String[] args) {

        // 多线程实现方式
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Thread thread = new Thread(r1);
        thread.start();
        System.out.println("************************");

        Runnable r2 = () -> System.out.println("World!!!");
        Thread thread1 = new Thread(r2);
        thread1.start();
        System.out.println("************************");

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        PriorityQueue<String> queue2 = new PriorityQueue<>((o1, o2) -> {
            return -1;
        });

        new LinkedList<String>();

    }

}
