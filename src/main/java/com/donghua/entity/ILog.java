package com.donghua.entity;

public interface ILog {

    /**
     * 记录-添加数据库记录
     */
    public void add(Log log);

    /**
     * 根据用户姓名和日期查询日志信息
     */
    public Log queryByName(String name, String date);
}
