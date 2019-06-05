package com.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于解决多线程安全问题的方式.
 * 1、同步代码块
 * 2、同步方法
 * 3、同步锁：显式锁，需要通过lock()方式加锁，unlock()方式解锁
 */
public class LockDemo {

	public static void main(String[] args) {

		Ticket ticket = new Ticket();

		new Thread(ticket, "窗口1").start();
		new Thread(ticket, "窗口2").start();
		new Thread(ticket, "窗口3").start();

	}

}

class Ticket implements Runnable {

	private int tick = 100;

	private Lock lock = new ReentrantLock();

	@Override
	public void run() {

		try {
			lock.lock(); // 加锁
			while (true) {
				if (tick > 0) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
				}
			}
		} finally {
			lock.unlock();// 释放锁
		}
	}
}
