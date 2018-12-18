package com.threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolDemo1
 * @Description 线程池学习 线程池：线程池是一种多线程的处理方式，处理过程中将任务提交到线程池，任务的执行交给线程池来管理 为什么要使用线程池：
 *              1、减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
 *              2、可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存，而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。
 * @Author Taowd
 * @Date 2018/6/17 13:08
 * @Version V1.0
 */
public class ThreadPoolDemo1 {
	public static void main(String[] args) {
//        //线程池1：newSingleThreadExecutor   单线程的线程池
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            pool.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + "\t开始发车啦----->" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//            });
//        }
//        //关闭线程池
//        pool.shutdown();
		// 线程池2：newFixedThreadPool 指定大小的线程池
		/**
		 * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
		 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
		 */
		ExecutorService pool = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 10; i++) {
			pool.execute(() -> {
				System.out.println(Thread.currentThread().getName() + "\t开始发车啦----->"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			});
		}
		// 关闭线程池
		pool.shutdown();

		// 检查线程是否执行完毕
		System.out.println(pool.isTerminated());

		// 线程池3：创建一个可缓存的线程池。
		// 如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲的线程，当任务数增加时，此线程池又添加新线程来处理任务。
//		ExecutorService pool2 = Executors.newCachedThreadPool();

		// 线程4：任务线程池 此线程池支持定时以及周期性执行任务的需求。 每秒执行输出一句话
		ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(10);
		scheduledPool.scheduleAtFixedRate(() -> {
			System.out.println("测试一下" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}, 1, 2, TimeUnit.SECONDS);

//自定义线程池核心在于创建一个ThreadPoolExecutor对象
		/**
		 * publicThreadPoolExecutor(int corePoolSize, nt maximumPoolSize,long
		 * keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
		 * ThreadFactory threadFactory, RejectedExecutionHandler handler);
		 *
		 * 
		 * 
		 * corePoolSize
		 * 线程池大小，决定着新提交的任务是新开线程去执行还是放到任务队列中，也是线程池的最最核心的参数。一般线程池开始时是没有线程的，只有当任务来了并且线程数量小于corePoolSize才会创建线程。
		 *
		 * maximumPoolSize 最大线程数，线程池能创建的最大线程数量。
		 *
		 * keepAliveTime 在线程数量超过corePoolSize后，多余空闲线程的最大存活时间。
		 *
		 * unit 时间单位
		 *
		 * workQueue 存放来不及处理的任务的队列，是一个BlockingQueue。
		 *
		 * threadFactory 生产线程的工厂类，可以定义线程名，优先级等。
		 *
		 * handler 拒绝策略，当任务来不及处理的时候，如何处理, 前面有讲解。
		 */

	}
}
