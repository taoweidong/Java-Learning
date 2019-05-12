package com.basicGrammar;

/**
 * �����⣺������δ������������ʲô
 * @author taowd
 * @version 2019��5��12��
 * @see StaticDemo
 */
public class StaticDemo extends Base {

	/*
	 * ������
	 * ����Ϊʲô���������������Ȳ����ۣ�������һ����δ�������ִ�й��̣���ִ�п�ʼ����ҪѰ�ҵ�main��������Ϊmain�����ǳ������ڣ�������ִ��main����֮ǰ�������ȼ���Test�࣬
	 * ���ڼ���Test���ʱ����Test��̳���Base�࣬��˻�תȥ�ȼ���Base�࣬�ڼ���Base���ʱ�򣬷�����static�飬��ִ����static�顣��Base��������֮�󣬱��������Test�࣬
	 * Ȼ����Test����Ҳ��static�飬��ִ��static�顣�ڼ������������֮�󣬱㿪ʼִ��main��������main������ִ��new Test()��ʱ����ȵ��ø���Ĺ�������Ȼ���ٵ�������Ĺ���������ˣ���������������������
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