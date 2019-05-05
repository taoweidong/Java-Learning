package com.java8;

/**
 * Java8接口
 * @author taowd
 * @version 2019年5月5日
 * @see Java8InterfaceDemo
 */
public interface Java8InterfaceDemo {

	/**
	 * Java8新特性 接口中的吗，默认方法.
	 * @return
	 * @see
	 */
	default String getName() {

		return "Hello World!!!";
	}

}
