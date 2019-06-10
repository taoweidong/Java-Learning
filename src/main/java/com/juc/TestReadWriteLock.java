package com.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock 读写锁:读和读互不影响，读和写互斥，写和写互斥，提高读写的效率<br/>
 * ReentrantReadWriteLock是Lock的另一种实现方式，我们已经知道了ReentrantLock是一个排他锁，同一时间只允许一个线程访问，
 * 而ReentrantReadWriteLock允许多个读线程同时访问，但不允许写线程和读线程、写线程和写线程同时访问。相对于排他锁，
 * 提高了并发性。在实际应用中，大部分情况下对共享数据（如缓存）的访问都是读操作远多于写操作，
 * 这时ReentrantReadWriteLock能够提供比排他锁更好的并发性和吞吐量。
 */
public class TestReadWriteLock {

	public static void main(String[] args) {

		ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

		new Thread(new Runnable() {

			@Override
			public void run() {

				readWriteLockDemo.set((int) (Math.random() * 101));
			}
		}, "Write").start();

		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					readWriteLockDemo.get();
				}
			}).start();
		}

	}
}

class ReadWriteLockDemo {

	private int number = 0;

	private ReadWriteLock lock = new ReentrantReadWriteLock();

	public void get() {

		lock.readLock().lock();

		try {
			System.out.println(Thread.currentThread().getName() + ":" + number);

		} finally {
			lock.readLock().unlock();
		}

	}

	public void set(int number) {

		lock.writeLock().lock();

		try {
			System.out.println(Thread.currentThread().getName());
			this.number = number;
		} finally {
			lock.writeLock().unlock();
		}

	}
}
