package com.data.structure.practice;

/**
 * 队列的学习代码
 * 
 * @author Taoweidong
 */
public class QueueDemo2 {

    public static void main(String[] args) {

        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        circleArrayQueue.addQueue(10);
        circleArrayQueue.addQueue(5);
        circleArrayQueue.addQueue(6);
        circleArrayQueue.showQueue();
        System.out.println("***********************");
        System.out.println(circleArrayQueue.getQueue());
        circleArrayQueue.showQueue();
        System.out.println("***********************");
        circleArrayQueue.addQueue(446);
        circleArrayQueue.showQueue();
        circleArrayQueue.addQueue(55);
    }

}

/**
 * 数组模拟环形队列
 */
class CircleArrayQueue {

    /**
     * 队列容量
     */
    private int maxLength;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 数据
     */
    private int[] data;

    public CircleArrayQueue(int maxLength) {

        this.maxLength = maxLength;
        // 初始化数组
        data = new int[this.maxLength];
    }

    /**
     * 是否满.
     * 
     * @return
     */
    public boolean isFull() {

        return (rear + 1) % maxLength == front;
    }

    /**
     * 是否为空
     * 
     * @return
     */
    public boolean isEmpty() {

        return rear == front;
    }

    public void addQueue(int input) {

        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        data[rear] = input;
        // 指定下一个位置：使用这种方式可以保证数组到最后一位以后获取的下一个位置为首位，行程循环链表的效果
        rear = (rear + 1) % maxLength;
    }

    public int getQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value = data[front];
        // 防止越界，产生循环链表的效果
        front = (front + 1) % maxLength;
        return value;
    }

    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列为空,没有数据！");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxLength, data[i % maxLength]);
        }

    }

    public int size() {

        return (rear + maxLength - front) % maxLength;
    }

    public int headQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据了");
        }
        return data[front + 1];
    }
}
