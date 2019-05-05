package com.java8;

/**
 * 类优先原则
 * @author taowd
 * @version 2019年5月5日
 * @see Java8InterfaceDemo3Impl
 */
public class Java8InterfaceDemo3Impl extends Java8Demo implements Java8InterfaceDemo {

	public static void main(String[] args) {

		Java8InterfaceDemo3Impl demo = new Java8InterfaceDemo3Impl();
		System.out.println(demo.getName());
	}
}
