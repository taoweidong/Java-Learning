package com.donghua;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Test36 {

	public static void main(String[] args) throws Exception {

		try {
			//读取文件
			List<String> inputStr = Files.readAllLines(Paths.get("hello.txt"));
			System.out.println(String.join(",", inputStr));
		} catch (IOException e) {
			//抛出异常，重新包装错误信息
			throw new Exception("文件读取异常");
		}
	}

}
