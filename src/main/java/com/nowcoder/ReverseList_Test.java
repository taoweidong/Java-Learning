package com.nowcoder;

/**
 * @ClassName ReverseList
 * @Description 输入一个链表，反转链表后，输出链表的所有元素。
 * @Author Taowd
 * @Version V1.0
 */
public class ReverseList_Test {

    /**
     * 定义链表结构
     */
    public static class ListNode {

        /**
         * 值
         */
        int val;

        /**
         * 后一个节点
         */
        ListNode next = null;

        /**
         * 构造函数
         * 
         * @param val
         */
        ListNode(int val) {

            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(12);
        ListNode node1 = new ListNode(34);
        ListNode node2 = new ListNode(45);
        ListNode node3 = new ListNode(55);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        // 遍历链表数据
        ListNode n = node;
        while (n != null) {
            if (n.next != null) {
                System.out.print(n.val + "-->");
            } else {
                System.out.print(n.val);
            }
            n = n.next;
        }
        System.out.println();

        ListNode n2 = ReverseList(node);
        while (n2 != null) {
            if (n2.next != null) {
                System.out.print(n2.val + "-->");
            } else {
                System.out.print(n2.val);
            }
            n2 = n2.next;
        }
        System.out.println();

        ListNode n3 = reverseList(node);
        while (n3 != null) {
            if (n3.next != null) {
                System.out.print(n3.val + "-->");
            } else {
                System.out.print(n3.val);
            }
            n3 = n3.next;
        }
        System.out.println();
    }

    /**
     * 将链表反转
     * 
     * @param heroNode
     *            待反转的链表
     */
    public static ListNode reverseList(ListNode heroNode) {
        // 只有一个节点或者链表为空，则直接返回
        if (heroNode.next == null || heroNode.next.next == null) {
            return null;
        }

        // 先定义一个新的根节点
        ListNode newNode = new ListNode(0);
        // 辅助变量，遍历旧链表
        ListNode current = heroNode.next;
        // 暂存下一个节点
        ListNode next = null;
        // 对原来的链表进行遍历，每遍历一个元素，就将这个节点挂载到新节点的前面
        while (current != null) {
            // 暂存下一节点的值
            next = current.next;
            // 把当前节点挂载到新根节点的前面
            current.next = newNode.next;
            // 注意此处：将新的头结点挂载到当前节点的前面，用于形成链式结构
            newNode.next = current;
            // 位置向后移动一位
            current = next;

        }
        heroNode.next = newNode.next;
        return heroNode;
    }

    public static ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        // 当前节点的前一个节点
        ListNode pre = null;
        // 当前节点的后一个节点
        ListNode next = null;

        while (head != null) {
            // 先用next存储head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而因此断裂
            next = head.next;
            // 保存完next，就可以让head从指向next转向指向pre
            head.next = pre;
            // head指向pre后，就可以继续下一个节点
            // 让pre head next依次向后移动，每移动到一个节点时进行指针反转操作
            pre = head;
            head = next;
        }
        // 如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        // 直接输出pre就是我们想要得到的反转后的链表
        return pre;

    }
}
