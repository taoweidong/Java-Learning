// 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对
// 了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
//
// 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
//
// 请注意秘密数字和朋友的猜测数都可能含有重复数字。
//
// 示例 1:
//
// 输入: secret = "1807", guess = "7810"
//
// 输出: "1A3B"
//
// 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
//
// 示例 2:
//
// 输入: secret = "1123", guess = "0111"
//
// 输出: "1A1B"
//
// 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
//
// 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
// Related Topics 哈希表

package com.leetcode;

import java.util.*;

/**
 * 猜数字游戏
 * 
 * @author Taoweidong
 */
public class BullsAndCows {

    public static void main(String[] args) {

        Solution solution = new BullsAndCows().new Solution();
        System.out.println(solution.getHint("1807", "7810"));
        System.out.println(solution.getHint("1123", "0111"));
        System.out.println(solution.getHint("1122", "2211"));
        System.out.println(solution.getHint("1122", "1222"));
        System.out.println(solution.getHint("5433519056", "5330810935"));

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String getHint(String secret, String guess) {

            // 公牛的个数：
            int A = 0;
            // 奶牛的个数
            int B = 0;

            List<Character> list = new ArrayList<>();
            // 不完全匹配的剩余数字
            for (Character item : secret.toCharArray()) {
                list.add(item);
            }

            // 先把位置和值匹配的找出来，并作一个标志
            List<Character> temp = new ArrayList<>();
            for (int i = 0; i < guess.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    A++;
                    list.set(i, '$');
                    continue;
                } else {
                    temp.add(guess.charAt(i));
                }
            }

            // 然后检查没有完全匹配的数据
            for (Character item : temp) {
                if (list.contains(item)) {
                    list.set(list.indexOf(item), '$');
                    B++;
                }
            }

            return A + "A" + B + "B";
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}