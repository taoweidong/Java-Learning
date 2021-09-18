// 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
// 网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
// 11110
// 11010
// 11000
// 00000
//
// 输出: 1
//
//
// 示例 2:
//
// 输入:
// 11000
// 11000
// 00100
// 00011
//
// 输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.huawei;

import java.util.Scanner;

/**
 * 有这样一题： 流水线N个产品每个产品有M个零件，Aij表示生产该零件的生产时间 需满足以下2个条件 1. Aij需要生产出来必须保证Ai-1 j先生产出来 2. Aij需要生产出来必须保证Ai j-1先生产出来 分析：
 * 明显的DP问题。设dp[i][j]是生产 到 第i个产品第j个零件所需要 总 的时间， 根据题意得到状态转移dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + nums[i][j]
 * (该零件所需要的时间)。 第一行第一列照抄，输出最后一个就对了 https://www.nowcoder.com/discuss/377231?order=0&page=1&pos=8&type=0
 * <p>
 * 测试用例1 1 3 3.0 2.0 1.0 输出6.000000
 * <p>
 * 测试用例2 3 1 3.0 2.0 1.0 输出6.000000
 * <p>
 * 测试用例3 2 4 10.000000 5.000000 4.500000 3.000000 4.499999 2.000000 2.000000 1.000000 输出：21.999999
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200404_06 {

    public static void main(String[] args) {
        float q = 14.9999f;
        float w = 15.9999f;

        System.out.println(Math.max(q, w));
        System.out.println(q + w);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] arr = in.nextLine().split(" ");
            // 产品数
            int n = Integer.valueOf(arr[0]);
            // 零件数
            int m = Integer.valueOf(arr[1]);
            // 零件产品生产所需的时间
            String[][] a = new String[m][n];

            for (int i = 0; i < m; i++) {
                String[] str = in.nextLine().split(" ");
                for (int j = 0; j < str.length; j++) {
                    a[i][j] = str[j];
                }

            }

            // 状态方式:标识第i个产品第j个零件所需要的总的时间
            double[][] dp = new double[m][n];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1] + Double.valueOf(a[i][j]);
                    }
                    if (j == 0 && i != 0) {
                        dp[i][j] = dp[i - 1][j] + Double.valueOf(a[i][j]);
                    }
                    if (j != 0 && i != 0) {
                        double maxValue = Math.max(dp[i - 1][j], dp[i][j - 1]) + Double.valueOf(a[i][j]);
                        dp[i][j] = maxValue;
                    }
                    if (j == 0 && i == 0) {
                        dp[i][j] = Double.valueOf(a[i][j]);
                    }
                }
            }

            System.out.println(dp[m - 1][n - 1]);

        }

    }

}