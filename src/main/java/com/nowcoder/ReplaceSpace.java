package com.nowcoder;

/**
 * @author Taowd
 * @Description 请实现一个函数，将一个字符串中的空格替换成“%20”
 */
public class ReplaceSpace {

	public static void main(String[] args) {

		StringBuffer temp = new StringBuffer("We Are Happy    test");

		System.out.println(temp);
		System.out.println(replaceSpace(temp));
	}

	/**
	 * 请实现一个函数，将一个字符串中的空格替换成“%20”
	 * @param str
	 * @return
	 */
	public static String replaceSpace(StringBuffer str) {

		return str.toString().replaceAll("\\s", "%20");
	}
}
