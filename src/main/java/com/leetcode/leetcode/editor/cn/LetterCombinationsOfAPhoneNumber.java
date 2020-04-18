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
        System.out.println(solution.letterCombinations("235"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //字典
        Map<String, String> map = new HashMap<String, String>(8) {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };


        //结果
        List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            backtrack("", digits);
            return result;
        }

        /**
         * 递归回溯
         * 如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
         *
         * @param s
         * @param digits
         * @return
         */
        private void backtrack(String s, String digits) {
            //递归退出条件
            if (digits == null || digits.length() == 0) {
                result.add(s);
            } else {

                String letter = map.get(digits.substring(0, 1));

                for (int i = 0; i < letter.length(); i++) {
                    String str = letter.substring(i, i + 1);
                    //此处采用回溯法
                    backtrack(s + str, digits.substring(1));
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}