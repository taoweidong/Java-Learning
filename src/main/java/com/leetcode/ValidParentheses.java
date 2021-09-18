// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
// 输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
// 输出: true
//
//
// 示例 3:
//
// 输入: "(]"
// 输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
// 输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
// 输出: true
// Related Topics 栈 字符串

package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 
 * @author Taoweidong
 */
public class ValidParentheses {

    public static void main(String[] args) {

        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("()[]{}"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {

            Stack<Character> stack = new Stack<>();

            for (Character item : s.toCharArray()) {
                if ('(' == item || '[' == item || '{' == item) {
                    stack.add(item);
                } else {
                    if (!stack.isEmpty() && isMatcher(stack.peek(), item)) {
                        // 出栈
                        stack.pop();
                    } else {
                        // 不匹配，直接结束
                        return false;
                    }
                }
            }
            // 为空时，说明匹配
            return stack.isEmpty();
        }

        /**
         * 两个括号是否匹配
         * 
         * @param top
         *            栈顶元素
         * @param ch
         *            入栈元素
         * @return true 匹配
         */
        public boolean isMatcher(Character top, Character ch) {

            Map<Character, Character> map = new HashMap<>(3);
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            if (map.get(top).equals(ch)) {
                return true;
            } else {
                return false;
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}