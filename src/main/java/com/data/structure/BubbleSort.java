package com.data.structure;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序算法
 * @author Taoweidong
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = generateRandomArray(10, 100);

		System.out.println(JSON.toJSONString(arr));
		bubbleSort(arr);
		System.out.println(JSON.toJSONString(arr));
	}

	/**
	 * 冒泡排序实现数组排序:N个数字冒泡排序，总共要进行N-1趟比较，每趟的排序次数为(N-i)次比较
	 * @param arr 待排序的数据
	 */
	private static void bubbleSort(int[] arr) {

		if (arr == null || arr.length < 2) {
			return;
		}

		//需要进行arr.length趟比较:
		for (int i = 0; i < arr.length; i++) {
			//第i趟比较：此处减去i的原因就是每进行一次比较就已经有一个最大的值或者最小的值沉到最后，下一次就少一趟比较
			for (int j = 0; j < arr.length - i - 1; j++) {
				// 开始进行比较，如果arr[j]比arr[j+1]的值大，那就交换位置
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 产生一个随机数组，数组的长度和值都是随机的，
	 * @param size
	 * @param value
	 * @return
	 */
	public static int[] generateRandomArray(int size, int value) {
		//在java中，Math.random() ->double(0,1)
		//(int)((size+1)*Math.random())--->产生的是[0,size]之间的整数
		//生成长度随机的数组，数组的最大长度是size的长度
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			//针对数组中的每个值都可以随机一下，一个随机数减去另外一个随机数，可能产生正数，也可能产生负数
			//值也可以是随机的
			arr[i] = (int) (value * Math.random());
		}
		return arr;
	}

}
