package com.data.structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列：先进先出
 */
public class QueueDemo {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(23);
		queue.add(45);
		queue.add(50);

		for (Integer item : queue) {
			System.out.println(item);
		}

	}

}
