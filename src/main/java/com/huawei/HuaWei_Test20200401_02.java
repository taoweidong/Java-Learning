package com.huawei;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母出现的次数，并按照字母出现的次数从大到小
 * 的顺序输出各个字母及其出现的次数信息，如果次数相同，按照自然顺序进行排序
 * @author Taoweidong
 */
public class HuaWei_Test20200401_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//输入参数
			String str = sc.nextLine();

			//统计字符出现的个数
			Data[] datas = new Data[28];
			for (Character item : str.toCharArray()) {
				Data data;
				if (datas[item - 'a'] != null) {
					data = datas[item - 'a'];
					data.count++;
				} else {
					data = new Data();
					data.ch = item.toString();
					data.count = 1;

				}
				datas[item - 'a'] = data;

			}

			//排序
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas.length - i - 1; j++) {
					if (datas[j].count < datas[j + 1].count) {
						Data temp = datas[j];
						datas[j] = datas[j + 1];
						datas[j + 1] = temp;
					}
				}
			}

			System.out.println(JSON.toJSONString(datas));

		}
	}
}

class Data {

	/**
	 * 字符
	 */
	public String ch;

	/**
	 * 数量
	 */
	public Integer count;
}
