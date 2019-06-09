package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为
 * A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要
 * 求输出的结果必须按顺序显示。
 * 如：ABCABCABC…… 依次递归
 * 线程通讯
 */
public class TestABCAlternate {

	public static void main(String[] args) {

		AlternateDemo alternateDemo = new AlternateDemo();

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 10; i++) {
					alternateDemo.ShowMsgA(i);
				}
			}
		}, "A").start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 10; i++) {
					alternateDemo.ShowMsgB(i);
				}
			}
		}, "B").start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 1; i <= 10; i++) {
					alternateDemo.ShowMsgC(i);
				}
			}
		}, "C").start();

	}
}

class AlternateDemo {

	// 标志第几个线程在执行的问题
	private int flag = 1;

	// 锁对象
	private Lock lock = new ReentrantLock();

	// 通讯对象
	private Condition conditionA = lock.newCondition();

	private Condition conditionB = lock.newCondition();

	private Condition conditionC = lock.newCondition();

	public void ShowMsgA(int totalLoop) {

		// 加锁
		lock.lock();

		try {

			// 判断是否是指定线程执行
			if (flag != 1) {
				conditionA.await();
			}

			System.out.println(Thread.currentThread().getName() + "---->" + totalLoop);

			// 唤醒B线程开始执行

			flag = 2;
			conditionB.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}

	}

	public void ShowMsgB(int totalLoop) {

		// 加锁
		lock.lock();

		try {

			// 判断是否是指定线程执行
			if (flag != 2) {
				conditionB.await();
			}

			System.out.println(Thread.currentThread().getName() + "---->" + totalLoop);

			// 唤醒B线程开始执行

			flag = 3;
			conditionC.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}

	}

	public void ShowMsgC(int totalLoop) {

		// 加锁
		lock.lock();

		try {

			// 判断是否是指定线程执行
			if (flag != 3) {
				conditionC.await();
			}

			System.out.println(Thread.currentThread().getName() + "---->" + totalLoop);

			// 唤醒A线程开始执行

			flag = 1;
			conditionA.signal();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放锁
			lock.unlock();
		}

	}

}
