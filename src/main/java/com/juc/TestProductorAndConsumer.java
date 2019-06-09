package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生成者消费者问题.
 */
public class TestProductorAndConsumer {

	public static void main(String[] args) {

		Clerk clerk = new Clerk();

		Productor productor = new Productor(clerk);
		Consumer consumer = new Consumer(clerk);

		new Thread(productor, "生产者A").start();
		new Thread(consumer, "消费者B").start();

		// 多个线程时会产生虚假唤醒的问题
		new Thread(productor, "生产者C").start();
		new Thread(consumer, "消费者D").start();

	}
}

// 店员
class Clerk {

	// 共享变量：存在多线程安全问题
	private int product = 0;

	// 锁对象
	private Lock lock = new ReentrantLock();

	// 对应唤醒机制
	private Condition condition = lock.newCondition();

	public void get() {

		lock.lock();

		try {
			while (product >= 1) {
				System.out.println("产品已满！");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 生产商品
			System.out.println(Thread.currentThread().getName() + "--->" + ++product);
			condition.signalAll();
		} finally {
			lock.unlock();
		}

	}

	public void sale() {

		// 加锁
		lock.lock();
		try {
			while (product <= 0) {
				System.out.println("缺货！");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "---->" + --product);
			condition.signalAll();
		} finally {
			// 释放锁
			lock.unlock();
		}
	}
}

// 生产者
class Productor implements Runnable {

	private Clerk clerk;

	public Productor(Clerk clerk) {

		this.clerk = clerk;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}

	}
}

// 消费者
class Consumer implements Runnable {

	private Clerk clerk;

	public Consumer(Clerk clerk) {

		this.clerk = clerk;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}
}
