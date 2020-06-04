package com.huawei.oo;

import java.util.*;

/**
 * 最大括号深度：
 * > 现有一字符串仅有'('，')'，'{'，'}'，'[',']'六种括号组成。
 * 若字符串满足以下条件之一，则视为无效字符串：
 * 1、任意类型的左右括号数量不相等。
 * 2、存在未按正确顺序（先左后右）闭合的括号。
 * 输出括号的最大嵌套深度，若字符串无效，输出0。0=<字符串长度<=100000。
 * <p>
 * - 输入描述：
 * 一个只包含'('，')'，'{'，'}'，'[',']'字符串。
 * - 输出描述：
 * 一个整数，最大的括号深度
 * <p>
 * - 示例1：
 * 输入
 * []
 * 输出
 * 1
 */
public class Huawei_20200603_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //字符映射表
            Map<Character, Character> map = new HashMap(3);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            //输入数据处理
            String str = sc.nextLine();

            if ("".equals(str.trim())) {
                System.out.println(0);
                return;
            }

            //记录长度
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            //记录字符
            Stack<Character> stackChar = new Stack<>();

            //最长有效括号子串的长度 ()(){}[]
            int count = 0;
            for (int i = 0; i < str.length(); i++) {

                if ('(' == str.charAt(i) || '[' == str.charAt(i) || '{' == str.charAt(i)) {
                    stack.add(i);
                    stackChar.add(str.charAt(i));
                } else {
                    if (!stackChar.isEmpty() && map.get(stackChar.peek()).equals(str.charAt(i))) {
                        //出栈
                        stack.pop();
                        stackChar.pop();
                        if (stack.isEmpty()) {
                            stack.add(i);
                            stackChar.add(str.charAt(i));
                        } else {
                            count = Math.max(count, i - stack.peek());
                        }
                    }

                }
            }
            System.out.println(count);

        }


    }


}
