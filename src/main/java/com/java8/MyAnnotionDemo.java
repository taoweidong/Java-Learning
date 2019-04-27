package com.java8;

import java.util.Objects;

public class MyAnnotionDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		// Class<MyAnnotionDemo> clazz = MyAnnotionDemo.class;
		// Method method = clazz.getMethod("show");
		// MyAnnotion[] mas = method.getAnnotationsByType(MyAnnotion.class);
		// for (MyAnnotion myAnnotion : mas) {
		// System.out.println(myAnnotion.value());
		// }

		show("dsds");

		show(null);
	}

	@MyAnnotion("HHHHHH")
	@MyAnnotion("WWWWW")
	public static void show(String str) {

		// Objects.requireNonNull(str);
		Objects.requireNonNull(str, "不能为空");

		System.out.println(str);

	}

}
