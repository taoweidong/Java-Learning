package com;

import cn.hutool.core.util.RuntimeUtil;

public class HuToolSimple {
    public static void main(String[] args) {
        String str = RuntimeUtil.execForStr("java -version");
        System.out.println(str);

        System.out.println(RuntimeUtil.execForLines("java -version"));
    }
}
