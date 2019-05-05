package com.java8;

public class Java8InterfaceDemoImpl {

	public static void main(String[] args) {

		Java8InterfaceDemo2Impl demo = new Java8InterfaceDemo2Impl();
		System.out.println(demo.getName());
	}
}

/**
 * 继承的多个接口中包含同一个名称的默认方法时，实现类必须进行重写，指明使用哪个接口的方法
 * @author taowd
 * @version 2019年5月5日
 * @see Java8InterfaceDemo2Impl
 */
class Java8InterfaceDemo2Impl implements Java8InterfaceDemo, Java8InterfaceDemo2 {

	@Override
	public String getName() {

		// TODO Auto-generated method stub
		return Java8InterfaceDemo2.super.getName();
	}

}
