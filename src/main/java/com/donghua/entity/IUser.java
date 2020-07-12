package com.donghua.entity;

import java.sql.SQLException;

public interface IUser {

    /**
     * 查询用户信息
     */
    public User queryByAccount(String DoctorNo) throws SQLException;

    /**
     * 开户功能-添加数据库记录
     */
    public void add(User user) throws SQLException;

    /**
     * 取款/存款操作-此处需要校验密码
     */
    public void edit(User user);

}
