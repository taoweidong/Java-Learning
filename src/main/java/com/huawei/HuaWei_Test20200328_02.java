package com.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 输入: "()"
 * 输出: true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 4
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200328_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Character, Character> map = new HashMap(3);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            Stack<Character> stack = new Stack<>();
            for (Character item : sc.nextLine().toCharArray()) {
                if ('(' == item || '[' == item || '{' == item) {
                    stack.add(item);
                } else {
                    if (!stack.isEmpty() && map.get(stack.peek()).equals(item)) {
                        //如果匹配就删除栈顶元素，也就是与之匹配的左括号
                        stack.pop();
                    }
                }
            }
            //如果最终栈中为空则匹配
            System.out.println(stack.isEmpty());
        }
    }
}
