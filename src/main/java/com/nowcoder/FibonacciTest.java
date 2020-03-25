package com.nowcoder;

/**
 * @author Taowd
 * @date 2018/5/21 - 21:42
 * @Description 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class FibonacciTest {

	public static void main(String[] args) {

		System.out.println(Fibonacci(20));
	}

	public static int Fibonacci(int n) {
		/**
		 * 斐波那契数列：f(0)=0,f(1)=1,f(n)=f(n-1)+f(n-2);
		 */
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
}
