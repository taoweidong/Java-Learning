package com.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性验证<br/>
 * https://www.cnblogs.com/it-life-nathan/p/6488757.html
 */
public class TestAtomicDemo {
    public static void main(String[] args) {

        AtomicThread ad = new AtomicThread();

        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }

    }
}

/**
 * 原子变量 CAS算法
 */
class AtomicThread implements Runnable {

    // private int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getMsg());
    }

    public String getMsg() {
        return this.getClass().getName() + "--" + serialNumber.getAndAdd(1);
    }
}
