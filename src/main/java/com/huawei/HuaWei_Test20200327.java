package com.huawei;

import java.util.Scanner;

/**
 * 删除链表指定节点
 * 
 * @author Taoweidong
 */
public class HuaWei_Test20200327 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 节点总数
            int count = Integer.valueOf(sc.nextLine());

            // 定义头结点
            Node head = new Node(Integer.valueOf(sc.nextLine()));
            // 构造链表结构
            for (int i = 0; i < count - 1; i++) {
                String[] str = sc.nextLine().split(" ");
                int now = Integer.valueOf(str[0]);
                int pre = Integer.valueOf(str[1]);
                insertNode(head, now, pre);

            }

            // 开始进行删除操作
            int delete = Integer.valueOf(sc.nextLine());
            Node tempNode = delete(head, delete);

            // 输出结果
            while (tempNode != null) {
                System.out.print(tempNode.val + " ");
                tempNode = tempNode.next;
            }

        }
    }

    /**
     * 删除一个节点
     * 
     * @param head
     * @param delete
     * @return
     */
    private static Node delete(Node head, int delete) {

        // 创建一个新节点
        Node newNode = new Node(0);
        newNode.next = head;

        Node pre = newNode;
        Node temp = head;
        while (temp != null) {
            if (temp.val == delete) {
                pre.next = temp.next;
                break;
            }
            temp = temp.next;
            pre = pre.next;

        }
        return newNode.next;

    }

    public static void insertNode(Node head, int now, int pre) {

        Node temp = head;
        Node node = new Node(now);
        while (temp != null) {
            if (temp.val == pre) {
                // 在temp后面插入now节点
                node.next = temp.next;
                temp.next = node;
                break;

            }
            temp = temp.next;
        }

    }
}

/**
 * 定义链表结构
 */
class Node {

    public int val;

    public Node next;

    public Node(int val) {

        this.val = val;
    }
}
