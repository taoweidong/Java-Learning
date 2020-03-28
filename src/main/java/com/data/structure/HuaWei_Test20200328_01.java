package com.data.structure;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @author Taoweidong
 */
public class HuaWei_Test20200328_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			//输入数据处理
			String str = sc.nextLine();

			Stack<Integer> stack = new Stack<>();
			stack.push(-1);

			int max = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(i);
				} else {
					//遇到一个)出栈
					stack.pop();
					if (stack.isEmpty()) {
						stack.push(i);
					} else {
						//然后计算最大长度
						max = Math.max(max, i - stack.peek());
					}
				}
			}
			System.out.println(max);

		}
	}
}
