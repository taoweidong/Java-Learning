package com.huawei.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * # 【计算堆栈中的剩余数字】--完成
 * # 计算堆栈中的剩余数字
 * > 向一个空栈中一次输入正整数，假设入栈元素N（1<=N<=2^31-1）,按顺序以此为Nx...N4、N3、N2、N1，每当元素入栈时，如果N1=N2+，，，+Ny（y的范围[2,x],1<=x<=1000）,则N1~Ny全部元素出栈，重新入栈新元素M（M=2*N1）。
 * 如以此向栈中存入6，1，2，3，当存入6，1，2时，栈底至栈顶依次为[6,1,2],当存入3时，3=2+1，3，2，1全部出栈，重新入栈元素6（6=2*3），此时栈中有元素6，因为6=6，所以两个6全部出栈，存入12，最终栈中只剩下一个元素12。
 * <p>
 * - 输入描述：
 * 使用单个空格隔开的正整数字符串。
 * 如”5 6 7 8“，左边的数字先入栈，输入的正整数个数为x，1<=x<=1000。
 * <p>
 * - 输出描述：最终栈中存留的元素值，元素值使用空格隔开，如”8 7 6 5“，栈顶数字在最左边。
 * <p>
 * - 示例1：
 * 输入：
 * 5 10 20 50 85 1
 * 输出：
 * 1 170
 * <p>
 * 输入：6 2 3 5 8  输出：8 10 6
 * 输入：5 2 3 5  输出：5 10
 * 输入：5 10 20 50 85 1 输出：1 170
 * 输入：10 20 30 60 输出：120
 */
public class Huawei_20200606_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().trim().split(" ");

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < input.length; i++) {
                //  检查栈中的元素是否等于当前入栈的数据
                stack = getNewStack(stack, Integer.valueOf(input[i]));
            }

            //处理输出结果
            List<String> output = new ArrayList<>(stack.size());
            while (!stack.isEmpty()) {
                output.add(String.valueOf(stack.pop()));
            }
            System.out.println(String.join(" ", output));
        }
    }


    private static Stack<Integer> getNewStack(Stack<Integer> stack, Integer s) {
        //输入：6 2 3 5 8 输出：8 10 6
        //输入：5 2 3 5 输出：5 10
        //输入：5 10 20 50 85 1 输出：1 170
        //输入：10 20 30 60 输出：120
        int count = 0;
        //对栈中的每一个元素进行处理
        for (int i = stack.size() - 1; i >= 0; i--) {
            count += stack.get(i);
            if (count == s) {
                //倒数删除元素到索引为i的地方，返回新栈
                stack = getDeleteStack(stack, i);
                s = count * 2;
                if (!stack.isEmpty()) {
                    //递归进行一次处理
                    getNewStack(stack, s);
                } else {
                    stack.add(s);
                }
                return stack;
            }

        }
        //遍历结束没有一个符合条件的，就把s加入到栈中
        stack.add(s);
        return stack;


    }

    /**
     * 从栈的后面开始删除，删除到索引位置为deleteIndex位置
     *
     * @param stack       待删除栈
     * @param deleteIndex 删除的索引
     * @return 新的栈
     */
    private static Stack<Integer> getDeleteStack(Stack<Integer> stack, int deleteIndex) {

        for (int j = stack.size() - 1; j >= deleteIndex; j--) {
            stack.remove(j);
        }

        return stack;
    }


}


