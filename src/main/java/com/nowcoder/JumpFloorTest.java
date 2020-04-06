package com.nowcoder;

/**
 * @author Taowd
 * @Description 跳台阶问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorTest {

    public static void main(String[] args) {

        System.out.println(JumpFloor(20));
    }

    /**
     * 青蛙跳台阶问题
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        /**
         * 分析： f(1)=1;f(2)=2;f(3)=3;f(4)=5....f(n)=f(n-1)+f(n-2)
         */
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}
