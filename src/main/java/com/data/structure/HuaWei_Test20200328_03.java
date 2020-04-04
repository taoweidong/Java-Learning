package com.data.structure;

import java.util.Scanner;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200328_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入参数
            String num1 = sc.nextLine();
            String num2 = sc.nextLine();

            //输出结果
            StringBuilder result = new StringBuilder();

            //计算过程
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            //进位的标志，如果进位只能是1
            int carry = 0;
            while (i >= 0 || j >= 0) {
                //从后往前取出每一位的数字，准备进行加法运算
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                //进行加法运算
                int temp = n1 + n2 + carry;
                //判断是否需要进位
                carry = temp >= 10 ? 1 : 0;
                //当前位进行加法以后的个位数
                int tempNum = temp >= 10 ? temp - 10 : temp;
                result.append(tempNum);
                //指针后移
                i--;
                j--;
            }
            if (carry == 1) {
                result.append(1);
            }
            System.out.println(result.reverse().toString());
        }
    }
}
