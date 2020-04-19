//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串


package com.leetcode.leetcode.editor.cn;

/**
 * 字符串相乘
 *
 * @author Taoweidong
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("123", "456"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            //入参校验
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }

            //存储结果
            int[] result = new int[num1.length() + num2.length()];

            //计算数字的各个位的结果
            for (int i = num1.length() - 1; i >= 0; i--) {
                //第一个乘子最右边的的数字
                int a = num1.charAt(i) - '0';
                for (int j = num2.length() - 1; j >= 0; j--) {
                    //第二个乘子最右边的数字
                    int b = num2.charAt(j) - '0';
                    //计算乘法
                    int sum = (result[i + j + 1] + a * b);
                    //取余放在当前位置上
                    result[i + j + 1] = sum % 10;
                    //取整数进位
                    result[i + j] += sum / 10;
                }
            }

            //处理结果
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                if (i == 0 && result[i] == 0) {
                    continue;
                } else {
                    out.append(result[i]);
                }
            }


            return out.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}