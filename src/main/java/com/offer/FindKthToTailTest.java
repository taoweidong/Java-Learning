package com.offer;

/**
 * @ClassName FindKthToTail
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 * @Author Taowd
 * @Version V1.0
 */
public class FindKthToTailTest {

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

        int k = 2;
        System.out.println("倒数第" + k + "个结点,计算结果:" + (FindKthToTail(node, k) == null ?
                null :
                FindKthToTail(node, k).val));
    }

    /**
     * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指针走(k-1)步，到达第k个节点。
     * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {

        //检查入参合法性
        if (head == null) {
            return null;
        }

        //定义两个指针
        ListNode pre = head;
        ListNode last = head;

        //先让第一个指针走k步到达k的位置
        for (int i = 0; i < k - 1; i++) {
            if (pre != null) {
                pre = pre.next;
            }
        }

        //然后让两个指针一起出发，当第一个指针走到最后时，第二个指针就在倒数第k个位置
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    // 定义链表结构
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

}
