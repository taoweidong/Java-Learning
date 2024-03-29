// 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
// 字符 数值
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
// I 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
// 示例 1:
//
// 输入: "III"
// 输出: 3
//
// 示例 2:
//
// 输入: "IV"
// 输出: 4
//
// 示例 3:
//
// 输入: "IX"
// 输出: 9
//
// 示例 4:
//
// 输入: "LVIII"
// 输出: 58
// 解释: L = 50, V= 5, III = 3.
//
//
// 示例 5:
//
// 输入: "MCMXCIV"
// 输出: 1994
// 解释: M = 1000, CM = 900, XC = 90, IV = 4.
// Related Topics 数学 字符串

package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * 
 * @author Taoweidong
 */
public class RomanToInteger {

    public static void main(String[] args) {

        Solution solution = new RomanToInteger().new Solution();
        System.out.println(solution.romanToInt("IV"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int romanToInt(String s) {

            Map<String, Integer> romanMap = new HashMap<String, Integer>(8) {

                {
                    put("I", 1);
                    put("V", 5);
                    put("X", 10);
                    put("L", 50);
                    put("C", 100);
                    put("D", 500);
                    put("M", 1000);

                    put("IV", 4);
                    put("IX", 9);
                    put("XL", 40);
                    put("XC", 90);
                    put("CD", 400);
                    put("CM", 900);
                }
            };

            int result = 0;

            while (s.length() != 0) {
                // 检查是否有两个数字的罗马字
                if (s.length() >= 2) {
                    String temp = s.substring(0, 2);
                    if (romanMap.containsKey(temp)) {
                        result += romanMap.get(temp);
                        s = s.substring(2);
                        continue;
                    }
                }
                result += romanMap.get(s.substring(0, 1));
                s = s.substring(1);
            }

            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
