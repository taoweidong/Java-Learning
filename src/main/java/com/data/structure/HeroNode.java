package com.data.structure;

import java.util.Objects;

import com.alibaba.fastjson.JSON;

/**
 * 单链表实现
 * @author Taoweidong
 */
public class HeroNode {

	public static void main(String[] args) {

		HeroNode node = new HeroNode(10, "晁盖");
		HeroNode node1 = new HeroNode(25, "宋江");
		HeroNode node2 = new HeroNode(22, "武松");

		node.add(node2);
		node.add(node1);

		node.showAll();
		System.out.println("***********************************");

	}

	/**
	 * 添加节点
	 * @param node
	 */
	public void add(HeroNode node) {

		// 遍历链表
		HeroNode tmp = this;
		while (Objects.nonNull(tmp.getNext())) {
			tmp = tmp.getNext();
		}
		tmp.setNext(node);
	}

	/**
	 * 显示链表信息
	 */
	public void showAll() {

		// 遍历链表
		HeroNode tmp = this;
		while (Objects.nonNull(tmp)) {
			System.out.printf("name=%s,age=%d\n", tmp.getName(), tmp.getAge());
			tmp = tmp.getNext();
		}
	}

	/**
	 * 年龄
	 */
	private int age;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 下一个人物信息
	 */
	private HeroNode next;

	public HeroNode(int age, String name) {

		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {

		return JSON.toJSONString(this);
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public HeroNode getNext() {

		return next;
	}

	public void setNext(HeroNode next) {

		this.next = next;
	}
}
