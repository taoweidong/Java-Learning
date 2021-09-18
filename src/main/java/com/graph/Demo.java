package com.graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        // 展开结果集数据库
        List<String> read_txt = new ArrayList<>();
        read_txt.add("Hello");

        // 将结果写入文件
        Path fpath = Paths.get("test.txt");
        // 创建文件
        if (!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
                Files.write(fpath, read_txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
