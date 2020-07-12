package com.donghua.entity;

import com.donghua.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserService implements IUser {
    @Override
    public User queryByAccount(String account) throws SQLException {

        // 执行的SQL语句!!!!!!!!!!!!!!!!!!!
        String sql = "SELECT * FROM `t_user` WHERE account = ?";

        RowsMapper<User> userRowsMapper = new UserRowsMapper();
        Object[] paramsList = {account};

        Connection connection = JdbcUtils.getConnection();
        List<User> users = JdbcUtils.executeQuery(connection, sql, paramsList, userRowsMapper);
        if (users.size() != 0) {
            return users.get(0);

        }
        return null;
    }

    @Override
    public void add(User user) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        // 执行的SQL语句!!!!!!!!!!!!!!!!!!!
        String sql = "insert into t_user (account,name,card_type,card_id,pwd,money)";
        sql += " value (?,?,?,?,?,?)";
        Object[] params = {user.getAccount(),
                user.getName(), user.getCard_type(), user.getCard_id(), user.getPwd(), user.getMoney()};
        JdbcUtils.insert(connection, sql, params);
    }

    @Override
    public void edit(User user) {

    }
}
