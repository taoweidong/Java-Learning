package com.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrentHash学习
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        // 采用锁分段机制 替代 Hashtable的独占锁，进而提高性能
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("zhangsan", "张三");

        concurrentHashMap.forEach((key, value) -> {
            System.out.println(key + "------>" + value);
        });

    }
}
