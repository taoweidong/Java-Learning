package com.offer;

import com.alibaba.fastjson.JSON;

/**
 * 问题描述：四则运算表达式求值
 *
 * @author Taoweidong
 */
public class HuaWeiTest_05 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//
//        showList(node1);
//        System.out.println("*************");
//        Node deleteNode = delete(node1, node3);
//        showList(deleteNode);
//        System.out.println("*************");
//        showList(node1);
//        System.out.println("*************");
//        System.out.println(JSON.toJSONString(getK(node1, 2).v));
        showList(node1);
        System.out.println("*************");
//        reverseList(node1);
        showList(reverseList(node1));
    }

    /**
     * 链表反转
     *
     * @param node
     */
    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        //开始反转操作
        //辅助变量，帮助遍历原来的链表
        Node curr = node;
        //当前节点的下一个节点
        Node next = null;
        //新节点
        Node newNode = new Node(0);
        while (curr != null) {
            //暂时当前节点的下一个节点
            next = curr.next;
            //头插节点
            curr.next = newNode.next;
            newNode.next = curr;
            //后移一次
            curr = next;
        }
        return newNode.next;
    }

    /**
     * 找链表倒数第k个节点
     *
     * @param node
     */
    public static Node getK(Node node, int k) {
        if (node == null) {
            return null;
        }

        Node pre = node;
        Node curr = node;

        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }

        while (pre != null) {
            pre = pre.next;
            curr = curr.next;
        }

        return curr;

    }

    /**
     * 链表遍历
     *
     * @param node
     */
    public static void showList(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        Node temp = node;
        while (temp != null) {
            System.out.println(temp.v);
            temp = temp.next;
        }

    }

    /**
     * 删除链表指定节点
     *
     * @param node
     */
    public static Node delete(Node node, Node delete) {
        if (node == null) {
            return null;
        }

        Node temp = node;
        while (true) {
            //找到要删除节点的前一个节点
            if (temp.next.v == delete.v) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return node;
    }


}

class Node {
    int v;
    Node next;

    public Node(int v) {
        this.v = v;
    }
}
