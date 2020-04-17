//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package com.leetcode.leetcode.editor.cn;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author Taoweidong
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("25"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            //结果
            List<String> result = new ArrayList<>();

            if (digits == null || digits.length() == 0) {
                return Collections.EMPTY_LIST;
            }

            //字典
            Map<String, String> map = new HashMap<>(8);
            map.put("2", "abc");
            map.put("3", "def");
            map.put("4", "ghi");
            map.put("5", "jkl");
            map.put("6", "mno");
            map.put("7", "pqrs");
            map.put("8", "tuv");
            map.put("9", "wxyz");

            result.addAll(backtrack("", digits, map));


            return result;
        }

        /**
         * 递归回溯
         *
         * @param s
         * @param digits
         * @param map
         * @return
         */
        private List<String> backtrack(String s, String digits, Map<String, String> map) {
            List<String> result = new ArrayList<>();
            //递归退出条件
            if (digits == null || digits.length() == 0) {
                result.add(s);
                return result;
            }
            String letter = map.get(digits.substring(0, 1));

            for (int i = 0; i < letter.length(); i++) {
                String str = letter.substring(i, i + 1);
                //回溯
                backtrack(s + str, digits.substring(1), map);
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}