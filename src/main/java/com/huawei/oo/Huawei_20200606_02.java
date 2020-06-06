package com.huawei.oo;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * # 【计算堆栈中的剩余数字】--未完成
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
 * 6 2 3 5 8
 * 5 2 3 5
 * 5 10 20 50 85 1
 */
public class Huawei_20200606_02 {
    public static void main(String[] args) {

//        Stack<Integer> tempS = new Stack<>();
//        tempS.add(5);
//        tempS.add(2);
//        tempS.add(3);
//        tempS.add(5);
//
//
//        getNewStack2(tempS);

//        for (int i = 0; i < tempS.size(); i++) {
//            System.out.println(tempS.get(i));
//        }


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().trim().split(" ");

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < input.length; i++) {

                //  检查栈中的元素是否等于当前入栈的数据
                stack.add(Integer.valueOf(input[i]));
                getNewStack2(stack);

            }


            List<String> output = new ArrayList<>(stack.size());
            while (!stack.isEmpty()) {
                output.add(String.valueOf(stack.pop()));
            }

            System.out.println(String.join(" ", output));
        }
    }

    private static Stack<Integer> getNewStack2(Stack<Integer> stack) {

        //  6 2 3 5 8
        //  5 2 3 5
        //  5 10 20 50 85 1
        //开始逻辑处理，不断出栈相加判断是否满足条件，如果满足则更新结果值
//        TODO 待完善
        int start = stack.peek();
        int index = stack.pop();

        while (!stack.isEmpty()) {

            int count = 0;
            int indexCount = 0;
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (count == index) {
                    break;
                } else {
                    count += stack.get(i);
                    indexCount++;
                }
            }


            //删除栈顶元素的个数
            if (count == index) {
                while (!stack.isEmpty()) {
                    for (int i = 0; i < indexCount; i++) {
                        stack.pop();
                    }
                    break;
                }
                //把新元素添加进去
                stack.add(index * 2);

            }


            if (stack.size() == 1) {
                if (stack.peek() == index) {
                    stack.pop();
                    stack.add(index * 2);
                } else {
                    stack.add(index);
                }
                break;
            }

            if (indexCount != stack.size()) {
                index = stack.pop();
            } else {
                break;
            }

        }

        if (stack.isEmpty()) {
            stack.add(index);
        }

        return stack;


    }

    private static Stack<Integer> getNewStack(Stack<Integer> stack, Integer s) {
        //记录原始数据，当已经入栈的所有元素均不满足条件时进行处理
        Stack<Integer> originStack = new Stack<>();
        originStack.addAll(stack);
        //处理结果，当满足条件时，会当这个结果集进行更新，最终以此结果答案返回
        Stack<Integer> result = new Stack<>();
        if (stack.isEmpty()) {
            result.add(s);
            return result;
        }
        result.addAll(stack);

        //  6 2 3 5 8
        //  5 2 3 5
        //  5 10 20 50 85 1
        //开始逻辑处理，不断出栈相加判断是否满足条件，如果满足则更新结果值
//        TODO 待完善
        Stack<Integer> tempS = new Stack<>();
        int count = 0;
        while (!result.isEmpty()) {
            if (count == s) {
//                result.add(count * 2);
                s = count * 2;
                tempS.clear();
                tempS.add(s);
                count = 0;
                continue;
            }
            int a = result.pop();
            count += a;
            tempS.add(a);
        }
        tempS.add(s);
        return tempS;

//        if (count == s) {
//            result.add(count * 2);
//            return result;
//        } else {
//            originStack.add(s);
//            return originStack;
//        }

    }


}


