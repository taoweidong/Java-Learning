package com.basic.grammar;

/**
 * 子类功能
 * @author taowd
 * @version 2019年5月15日
 * @see Children
 */
public class Children extends Parents {

	/*
	 * 子类继承父类，子类拥有了父类的所有属性和方法。
	 * 程序验证，父类的私有属性和方法子类是无法直接访问的。当然私有属性可以通过public修饰的getter和setter方法访问到的，但是私有方法不行。
	 * 假设：子类不能够继承父类的私有属性和方法
	 * 那么：分析内存后，会发现，当一个子类被实例化的时候，默认会先调用父类的构造方法对父类进行初始化，即在内存中创建一个父类对象，然后再父类对象的外部放上子类独有的属性，
	 * 两者合起来成为一个子类的对象。
	 * 所以：子类继承了父类的所有属性和方法或子类拥有父类的所有属性和方法是对的，只不过父类的私有属性和方法，子类是无法直接访问到的。即只是拥有，但是无法使用。
	 * 参考：https://blog.csdn.net/evilcry2012/article/details/54405678
	 */

	private String msg;

	public String getMsg() {

		return super.getName() + " 今年" + super.getAge() + " 岁了 \n" + this.msg + "---->"
				+ super.birthday;
	}

	public static void main(String[] args) {

		Children children = new Children();
		// 父类信息
		children.setName("张三");
		children.setAge(23);
		children.birthday = "生日快乐---";

		// 子类信息
		children.msg = "孩子的信息";

		System.out.println(children.getMsg());
	}

}
