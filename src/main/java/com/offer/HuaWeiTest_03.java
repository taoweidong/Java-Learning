package com.offer;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * 问题描述：四则运算表达式求值
 *
 * @author Taoweidong
 */
public class HuaWeiTest_03 {
    public static void main(String[] args) {

        String str = "3+3+45*2-9/3";
        String[] strArray = str.split("\\+|\\-|\\*|\\/");

        System.out.println(JSON.toJSONString(str.split("\\+|\\-|\\*|\\/")));

        Stack<Integer> number = new Stack<>();
        Stack<Character> oper = new Stack<>();

        for (int i = 0; i < strArray.length; i++) {
            char item = str.charAt(i);
            if (isNumber(item)) {
                // 如果是数字，直接入栈
                number.push(item - '0');
            } else {
                if (oper.isEmpty()) {
                    oper.push(item);
                } else {
                    // 检查优先级
                    if (priority(item) <= priority(oper.peek())) {
                        // 计算值，然后加入到数栈中
                        int a = number.pop();
                        int b = number.pop();
                        number.push(cal(a, b, oper.pop()));
                        oper.push(item);
                    } else {
                        oper.push(item);
                    }
                }
            }
        }

        // 测试结果
        System.out.println(JSON.toJSONString(number));
        System.out.println(JSON.toJSONString(oper));

        while (true) {
            if (oper.isEmpty()) {
                break;
            }
            int a = number.pop();
            int b = number.pop();
            number.push(cal(a, b, oper.pop()));
        }

        // 最终计算结果
        System.out.println(number.pop());

    }

    /**
     * 计算值
     *
     * @param a
     * @param b
     * @param oper
     * @return
     */
    public static int cal(int a, int b, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = a + b;
                break;
            case '-':
                // 注意顺序
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = b / a;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 检查是否为数字
     *
     * @param val
     *            检查的字符
     * @return True:为数字
     */
    public static boolean isNumber(char val) {
        return '0' <= val && val <= '9';
    }

    /**
     * 检查运算符优先级
     *
     * @param oper
     *            操作符
     * @return 优先级
     */
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

}
