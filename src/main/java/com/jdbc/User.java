package com.jdbc;

import java.util.Date;

public class User {

	private String id;

	private String name;

	private Integer age;

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Integer getAge() {

		return age;
	}

	public void setAge(Integer age) {

		this.age = age;
	}

	public Date getBirthday() {

		return birthday;
	}

	public void setBirthday(Date birthday) {

		this.birthday = birthday;
	}

	private Date birthday;
}
