package com.donghua;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Test40 {

	public static void main(String[] args) {

		Hello hello = new Hello();
		List<Field> fields = getFiledList(hello.getClass());
		for (Field field : fields) {
			System.out.println(JSON.toJSONString(field));
		}

	}

	/**
	 * 获取给定类和其父类的所有属性名称
	 * @param clazz 给定类
	 * @return 所有属性集合
	 */
	public static List<Field> getFiledList(Class<?> clazz) {

		if (Objects.isNull(clazz)) {
			return null;
		}
		List<Field> fieldList = new LinkedList<>();
		//获取当前类的所有属性
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			//过滤不需要的属性，此处题目没有要求,就将所有的属性，包括静态属性和transient关键字修饰的属性全部取出
			//如果不需要就在这里进行过滤
			fieldList.add(field);
		}

		//处理父类属性，此处使用到迭代的方式
		Class<?> superClass = clazz.getSuperclass();
		if (superClass.equals(Object.class)) {
			//如果是顶级类Class,题目中有要求，不需要Object的属性，则结束处理
			return fieldList;
		}
		fieldList.addAll(getFiledList(superClass));
		return fieldList;

	}

}

class Parent {

	/**
	 * 父类属性1
	 */
	public String parent1;

	/**
	 * 父类属性2
	 */
	public String parent2;
}

class Hello extends Parent {

	/**
	 * Hello属性1
	 */
	public String hello1;

	/**
	 * Hello属性2
	 */
	public String hello2;
}


