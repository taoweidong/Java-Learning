package com.java8;

import com.alibaba.fastjson.JSON;

public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    private Double salary;

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

    public Employee() {

        super();
    }

    public Employee(Integer id, String name, Integer age, Double salary) {

        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

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

    public Double getSalary() {

        return salary;
    }

    public void setSalary(Double salary) {

        this.salary = salary;
    }

}
