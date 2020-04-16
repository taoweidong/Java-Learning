//给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。 
//
// 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。 
//
// 山羊拉丁文的规则如下： 
//
// 
// 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。 
// 例如，单词"apple"变为"applema"。 
// 
// 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。 
// 例如，单词"goat"变为"oatgma"。 
// 
// 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。 
// 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。 
// 
//
// 返回将 S 转换为山羊拉丁文后的句子。 
//
// 示例 1: 
//
// 
//输入: "I speak Goat Latin"
//输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// 
//
// 示例 2: 
//
// 
//输入: "The quick brown fox jumped over the lazy dog"
//输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaa
//aaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
// 
//
// 说明: 
//
// 
// S 中仅包含大小写字母和空格。单词间有且仅有一个空格。 
// 1 <= S.length <= 150。 
// 
// Related Topics 字符串


package com.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 山羊拉丁文
 *
 * @author Taoweidong
 */
public class GoatLatin {
    public static void main(String[] args) {
        Solution solution = new GoatLatin().new Solution();
        System.out.println(solution.toGoatLatin("I speak Goat Latin"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toGoatLatin(String S) {

            List<String> out = new ArrayList<>(S.length());

            String[] arr = S.split(" ");
            for (int i = 0; i < arr.length; i++) {
                out.add(dealStr(arr[i], i + 1));
            }


            return String.join(" ", out);
        }

        private String dealStr(String s, int num) {
            String result = "";
            //如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。例如，单词"apple"变为"applema"。
            if (isVowel(s.charAt(0))) {
                result = s + "ma";
            } else {
                result = s.substring(1) + s.charAt(0) + "ma";
            }
            String temp = "";
            for (int j = 0; j < num; j++) {
                temp += "a";
            }


            return result + temp;
        }

        /**
         * 判断给定字符是否是元音字符
         *
         * @param c 待判断字符
         * @return True:元音字符  False:非元音字符
         */
        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}