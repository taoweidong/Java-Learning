package com.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 学习CopyOnWriteArrayList 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。 并发迭代操作多时可以选择它
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {

        HelloThread helloThread = new HelloThread();

        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }

    }
}

/**
 * 多线程
 */
class HelloThread implements Runnable {

    // private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

            list.add("HH");
        }
    }
}
