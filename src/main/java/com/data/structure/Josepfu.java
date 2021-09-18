package com.data.structure;

/**
 * 约瑟夫环问题
 *
 * @author Taoweidong
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        // circleSingleLinkedList.showList();

        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

/**
 * 单向环形链表
 */
class CircleSingleLinkedList {
    /**
     * 创建第一个值
     */
    private Boy first = new Boy(-1);

    /**
     * 添加节点，构建环形链表
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("至少添加一个节点信息：nums>=1");
            return;
        }
        Boy currBoy = null;

        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建节点
            Boy item = new Boy(i);
            // 如果是第一个节点
            if (i == 1) {
                first = item;
                first.next = first;
                currBoy = first;

            } else {
                currBoy.next = item;
                item.next = first;
                currBoy = item;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void showList() {
        if (first == null) {
            System.out.println("没有任何节点");
            return;
        }

        // 辅助指针
        Boy currBog = this.first;
        while (true) {
            System.out.println("节点编号：" + currBog.no);
            // 遍历完毕
            if (currBog.next == first) {
                break;
            }
            // 遍历指针后移一位
            currBog = currBog.next;
        }
    }

    /**
     * 根据用户的输入，打印小孩出圈的顺序
     *
     * @param startNo
     *            表示从第几个小孩开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有几个小孩在圈里面
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入数据有误");
            return;
        }
        // 创建辅助指针
        Boy helper = first;
        // 找到当前环形队列的最后一个节点
        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        // 报数，出圈
        // 移动到第startNo小孩处
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;

        }

        // 小孩开始报数，移动countNum-1次 出圈
        while (true) {
            // 出圈完毕，圈里面只有一个人
            if (helper == first) {
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            // 此时first指向的节点就是要出圈的节点
            System.out.printf("小孩%s出圈\n", first.no);
            // 这时将first指向的节点出圈
            first = first.next;
            helper.next = first;

        }
        System.out.printf("最后留在圈中的小孩%s\n", first.no);

    }
}

class Boy {
    /**
     * 当前节点编号
     */
    public int no;
    /**
     * 下一个节点
     */
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
