package com.juc;

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

		//多个线程时会产生虚假唤醒的问题
		new Thread(productor, "生产者C").start();
		new Thread(consumer, "消费者D").start();

	}
}

// 店员
class Clerk {

	// 共享变量：存在多线程安全问题
	private int product = 0;

	public synchronized void get() {

		// 2. 生产者获取线程 此时product=0
		if (product >= 1) {// product =0
			System.out.println("产品已满！");
			try {
				// 5 生产者抢到资源获取线程 此时product=1，线程等待，此时没有其他线程唤醒，形成死锁问题
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 生产商品
		// 3. 生产者获取线程 此时product=1，此时唤醒消费者
		System.out.println(Thread.currentThread().getName() + "--->" + ++product);
		this.notifyAll();
	}

	public synchronized void sale() {

		// 1. 消费者获取线程 此时product=0 循环次数为 0
		if (product <= 0) {
			System.out.println("缺货！");
			try {
				this.wait();// 2. 消费者获取线程 此时线程等待，线程再次被唤醒后从这里开始继续往下执行
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "---->" + --product);
		this.notifyAll();
		// 4 消费者抢到资源获取线程 此时product=1，继续执行，执行后product=0
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
