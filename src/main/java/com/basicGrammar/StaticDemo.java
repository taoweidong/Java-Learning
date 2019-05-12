package com.basicGrammar;

/**
 * 面试题：下面这段代码的输出结果是什么
 * @author taowd
 * @version 2019年5月12日
 * @see StaticDemo
 */
public class StaticDemo extends Base {

	/*
	 * 分析：
	 * 至于为什么是这个结果，我们先不讨论，先来想一下这段代码具体的执行过程，在执行开始，先要寻找到main方法，因为main方法是程序的入口，但是在执行main方法之前，必须先加载Test类，
	 * 而在加载Test类的时候发现Test类继承自Base类，因此会转去先加载Base类，在加载Base类的时候，发现有static块，便执行了static块。在Base类加载完成之后，便继续加载Test类，
	 * 然后发现Test类中也有static块，便执行static块。在加载完所需的类之后，便开始执行main方法。在main方法中执行new Test()的时候会先调用父类的构造器，然后再调用自身的构造器。因此，便出现了上面的输出结果。
	 */

	static {
		System.out.println("test static");
	}

	public StaticDemo() {

		System.out.println("test constructor");
	}

	public static void main(String[] args) {

		new StaticDemo();
	}
}

class Base {

	static {
		System.out.println("base static");
	}

	public Base() {

		System.out.println("base constructor");
	}
}