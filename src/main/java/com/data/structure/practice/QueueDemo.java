package com.data.structure.practice;

/**
 * 队列的学习代码
 * @author Taoweidong
 */
public class QueueDemo {

	public static void main(String[] args) {

		ArrayQueue arrayQueue = new ArrayQueue(3);
		System.out.println(arrayQueue.isEmpty());
		arrayQueue.showQueue();
		// 添加队列数据
		arrayQueue.addQueue(10);
		arrayQueue.addQueue(5);
		arrayQueue.addQueue(8);
		arrayQueue.addQueue(9);
		// 展示队列中的所有数据
		arrayQueue.showQueue();

		// 查看队列头数据
		System.out.println(arrayQueue.headQueue());
		// 取出数据
		System.out.println(arrayQueue.getQueue());

	}

}

/**
 * 用数组实现队列的数据结构
 */
class ArrayQueue {

	/**
	 * 数组的最大容量
	 */
	private int maxLength;

	/**
	 * 队列头
	 */
	private int front;

	/**
	 * 队列尾
	 */
	private int rear;

	/**
	 * 实际的数据存储
	 */
	private int[] data;

	/**
	 * 创建队列的构造器
	 * @param maxLength 当前栈的最大容量
	 */
	public ArrayQueue(int maxLength) {

		this.maxLength = maxLength;
		data = new int[this.maxLength];
		// 指向队列的头部的前一个位置
		front = -1;
		// 指向队列的尾部
		rear = -1;
	}

	/**
	 * 判断当前队列是否已经满了
	 * @return True:已满 False:未满
	 */
	public boolean isFull() {

		return rear == maxLength - 1;
	}

	/**
	 * 判断当前队列是否为空
	 * @return True:为空 False:不为空
	 */
	public boolean isEmpty() {

		return rear == front;
	}

	/**
	 * 添加数据到队列中
	 * @param input 添加数据
	 */
	public void addQueue(int input) {

		if (isFull()) {
			System.out.println("队列已满，不能加入数据!");
			return;
		}
		// 移动指针
		rear++;
		data[rear] = input;

	}

	/**
	 * 获取队列的数据
	 * @return 当前队列中的第一个数据
	 */
	public int getQueue() {

		if (isEmpty()) {
			System.out.println("队列为空，无数据！");
			throw new RuntimeException("队列为空，无数据");
		}
		// 移动尾指针
		front++;
		return data[front];
	}

	/**
	 * 展示队列数据
	 */
	public void showQueue() {

		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}

		for (int i = 0; i < data.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, data[i]);
		}
	}

	/**
	 * 队列头数据
	 * @return 队列头数据
	 */
	public int headQueue() {

		if (isEmpty()) {
			System.out.println("队列为空，无数据！");
			throw new RuntimeException("队列为空，无数据");
		}

		return data[front + 1];
	}

}
