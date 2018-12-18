package com.nowcoder;

/**
 * @author Taowd
 * @date 2018/5/22 - 23:08
 * @Description 变态跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorIITest {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(100));

    }

    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

}
