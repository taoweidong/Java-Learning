package com.stringutils.demo;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

/**
 * SttringUtils测试
 */
public class StringUtilsDemo {

	public static void main(String[] args) {

		System.out.println(ObjectUtils.identityToString("22222"));

		System.out.println(ObjectUtils.notEqual("11", "22"));

		Objects.equals("", "");

	}
}
