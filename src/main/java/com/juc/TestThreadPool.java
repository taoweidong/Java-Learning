package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建和销毁线程的开销
 * newFixedThreadPool：创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 */
public class TestThreadPool {

	public static void main(String[] args) {

		ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

		// 1.创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// 2.为线程池中的线程分配任务
		for (int i = 0; i < 10; i++) {
			pool.submit(threadPoolDemo);
		}
		// 3.关闭线程池
		pool.shutdown();

	}
}

/**
 * 多线程
 */
class ThreadPoolDemo implements Runnable {

	private int index = 0;

	@Override
	public void run() {

		while (index <= 100) {
			System.out.println(Thread.currentThread().getName() + "-->" + index++);
		}
	}
}
