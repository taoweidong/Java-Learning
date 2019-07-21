package com.basic.grammar;

import java.util.List;

/**
 * 接口示例.
 * @author taowd
 */
public interface TestInterface {

	/**
	 * 接口中的常量默认修饰符为  public static final
	 */
	String SUCCESS_FLAG = "success";

	/**
	 * 接口中的抽象方法.
	 * @return 返回值
	 */
	List<String> getList();

	/**
	 * jdk1.8后允许接口中定义静态方法.
	 * @return 返回值
	 */
	static String sayHello() {

		return "Hello World!";
	}

	/**
	 * jdk1.8后允许接口中定义默认方法.
	 * 默认方法：如果子类不进行重写时，子类对象调用的就是接口中的默认方法
	 * @return 返回值
	 */
	default String sayHello2() {

		return "Hello World!";
	}
}
