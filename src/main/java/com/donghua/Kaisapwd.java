package com.donghua;

/**
 * 凯撒密码解密问题：https://blog.csdn.net/qq_43968080/article/details/85067324 –解密过程–
 * <p>
 * 移位加密的解密过程有两种： 1、当知道密文和密钥时，利用和加密同样的方法，进行反向移位替换，即可得出明文；
 * 2、当只知道密文，不知道密钥时，因为移位加密是根据26字母表来进行移位加密的，当移位为0和26时，结果一致，所以总共有25种情况。可以通过穷举的方法测试每一种情况，来猜出明文。
 * <p>
 * 凯撒密码的加密解密算法，逻辑很简单，就是两个公式： 比如说下面这个例子的加密解密公式，就是位移量为3时的结果 加密公式 f(a)=(a+3) mod 26 解密公式 f(a)=(a+23) mod 26
 */
public class Kaisapwd {

    public static void main(String[] args) {
        String input = "BJQHTRJ YT GMS";

        for (int k = 0; k < 26; k++) {
            StringBuilder result = new StringBuilder(input.length());
            for (int i = 0; i < input.length(); i++) {
                char item = input.charAt(i);
                if (item >= 'A' && item <= 'Z') {
                    result.append((char)((item - 'A' + k) % 26 + 'A'));
                } else if (item >= 'a' && item <= 'z') {
                    result.append((char)((item - 'a' + k) % 26 + 'a'));
                } else {
                    result.append(input.charAt(i));
                }
            }
            System.out.println("偏移量：" + k + " 明文：" + result.toString());
        }
    }
}
