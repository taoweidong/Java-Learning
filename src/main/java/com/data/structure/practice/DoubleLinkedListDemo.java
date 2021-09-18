package com.data.structure.practice;

/**
 * 双向链表实现
 * 
 * @author Taoweidong
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode2 head1 = new HeroNode2(1, "张三");
        HeroNode2 head2 = new HeroNode2(2, "李四");
        HeroNode2 head3 = new HeroNode2(3, "王五");
        HeroNode2 head4 = new HeroNode2(4, "马六");
        HeroNode2 head5 = new HeroNode2(5, "狗七");

        head1.next = head2;
        head2.pre = head1;
        head2.next = head3;
        head3.pre = head2;
        head3.next = head4;
        head4.pre = head3;
        head4.next = head5;

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.showList(head1);
    }

}

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "");

    public HeroNode2 getHead() {

        return head;
    }

    public void showList(HeroNode2 node) {

        HeroNode2 temp = node;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }

}

class HeroNode2 {

    public HeroNode2(int no, String name) {

        this.no = no;
        this.name = name;
    }

    /**
     * 编号
     */
    public int no;

    /**
     * 姓名
     */
    public String name;

    /**
     * 指向前一个节点
     */
    public HeroNode2 pre;

    /**
     * 指向后一个节点
     */
    public HeroNode2 next;

    @Override
    public String toString() {

        return "HeroNode2{" + "no=" + no + ", name='" + name + '\'' + '}';
    }
}
