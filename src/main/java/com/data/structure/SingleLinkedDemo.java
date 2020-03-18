package com.data.structure;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 单链表实现
 * @author Taoweidong
 */
public class SingleLinkedDemo {

	public static void main(String[] args) {

		SingleHeroNode node1 = new SingleHeroNode(1, "张三", 12);
		SingleHeroNode node2 = new SingleHeroNode(3, "李四", 66);
		SingleHeroNode node3 = new SingleHeroNode(4, "王五", 25);
		SingleHeroNode node4 = new SingleHeroNode(5, "马六", 23);

		SingleHeroNodeManage singleNode = new SingleHeroNodeManage();
		singleNode.addByOrder(node1);
		singleNode.addByOrder(node4);
		singleNode.addByOrder(node3);
		singleNode.addByOrder(node2);
		singleNode.showAll();

		System.out.println("**************************************");
		SingleHeroNode node4New = new SingleHeroNode(55, "马六000000000", 555);
		singleNode.update(node4New);
		singleNode.showAll();

		System.out.println("**************************************");
		singleNode.delete(node4New);
		singleNode.showAll();

		System.out.println("**************************************");
		System.out.println(getLength(singleNode.getHead()));

		System.out.println("**************************************");
		System.out.println(findLastIndexNode(singleNode.getHead(), 1));
	}

	/**
	 * 获取倒数第K个节点的数据
	 * @param heroNode 节点
	 * @param index    倒数第index节点
	 * @return 节点信息
	 */
	public static SingleHeroNode findLastIndexNode(SingleHeroNode heroNode, int index) {

		if (Objects.isNull(heroNode)) {
			return null;
		}

		int size = getLength(heroNode);

		//检查规范性
		if (index <= 0 || index > size) {
			return null;
		}

		SingleHeroNode temp = heroNode.next;
		for (int i = 1; i <= size - index; i++) {
			temp = temp.next;
		}

		return temp;

	}

	/**
	 * 获取链表的个数
	 * @param heroNode
	 * @return
	 */
	public static int getLength(SingleHeroNode heroNode) {

		if (Objects.isNull(heroNode.next)) {
			return 0;
		}

		SingleHeroNode temp = heroNode.next;
		int count = 0;
		while (Objects.nonNull(temp)) {
			temp = temp.next;
			count++;
		}

		return count;
	}

}

/**
 * 管理器
 */
class SingleHeroNodeManage {

	/**
	 * 返回头结点
	 * @return
	 */
	public SingleHeroNode getHead() {

		return head;
	}

	/**
	 * 先初始化一个头结点:一般不需要动
	 */
	private SingleHeroNode head = new SingleHeroNode(0, StringUtils.EMPTY, 0);

	/**
	 * 删除节点
	 * @param node
	 */
	public void delete(SingleHeroNode node) {

		SingleHeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (Objects.isNull(temp.next)) {
				System.out.println("链表为空");
				break;
			}

			if (temp.next.no == node.no) {
				//找到了待修改的节点
				flag = true;
				break;
			}
			//如果没有找到，则节点继续后移
			temp = temp.next;
		}
		if (flag) {
			//删除当前节点：实际上也就是将待删除节点的前一个节点的next指向修改
			temp.next = temp.next.next;
		} else {
			System.out.println("没有带删除的节点：" + node.no);
		}
	}

	/**
	 * 更新节点
	 * @param node 节点
	 */
	public void update(SingleHeroNode node) {

		SingleHeroNode temp = head;

		while (true) {
			if (Objects.isNull(temp.next)) {
				System.out.println("链表为空");
				break;
			}

			if (temp.next.no == node.no) {
				//找到了待修改的节点
				temp.next.name = node.name;
				temp.next.age = node.age;
				break;
			}
			//如果没有找到，则节点继续后移
			temp = temp.next;
		}

	}

	/**
	 * 添加有序的节点
	 * @param node 节点
	 */
	public void addByOrder(SingleHeroNode node) {

		SingleHeroNode temp = head;
		// 检查当前节点是否已经存在
		boolean flag = false;

		while (true) {
			// 如果当前链表为空：则可以直接插入
			if (Objects.isNull(temp.next)) {
				break;
			}

			// 找到了当前待插入节点的位置
			if (temp.next.no > node.no) {
				break;
			} else if (temp.next.no == node.no) {
				flag = true;
				break;
			}
			// 没有找到对应的节点：移动当前节点位置到下一个节点
			temp = temp.next;

		}

		if (flag) {
			System.out.println("待插入节点已经存在：" + node.no);
		} else {
			// 增加节点
			node.next = temp.next;
			temp.next = node;
		}

	}

	/**
	 * 添加一个节点.
	 * @param node 节点
	 */
	public void add(SingleHeroNode node) {

		// 1、找到当前链表的最后节点
		// 2、将最后这个节点的next指向新的节点
		SingleHeroNode temp = head;
		while (true) {
			// 找到链表的结尾
			if (Objects.isNull(temp.next)) {
				break;
			}
			// 如果没有找到继续后移
			temp = temp.next;
		}
		// 退出循环时，temp就指向链表的最后
		// 把新增的节点加到链表的最后
		temp.next = node;

	}

	public void showAll() {

		// 判断链表是否为空
		if (Objects.isNull(head.next)) {
			System.out.println("链表为空");
			return;
		}

		SingleHeroNode temp = head.next;
		while (true) {
			if (Objects.isNull(temp)) {
				break;
			}
			// 输出当前节点
			System.out.println(temp.toString());
			// 将下一个节点后移
			temp = temp.next;
		}

	}

}

/**
 * 节点对象
 */
class SingleHeroNode {

	public int no;

	public String name;

	public int age;

	public SingleHeroNode next;

	/**
	 * 构造器
	 * @param no   编号
	 * @param name 姓名
	 * @param age  年龄
	 */
	public SingleHeroNode(int no, String name, int age) {

		this.no = no;
		this.name = name;
		this.age = age;
	}

	@Override public String toString() {

		return "SingleHeroNode{" + "no=" + no + ", name='" + name + '\'' + ", age=" + age + "}";
	}
}
