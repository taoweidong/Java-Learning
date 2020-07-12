package com.donghua.entity;


import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowsMapper implements RowsMapper<User> {
    @Override
    public User getEntity(ResultSet rs) throws SQLException {
        User user = new User();
        user.setAccount(rs.getString("account"));
        user.setName(rs.getString("name"));
        user.setCard_type(rs.getString("card_type"));
        user.setCard_id(rs.getString("card_id"));
        user.setPwd(rs.getString("pwd"));
        user.setMoney(BigInteger.valueOf(rs.getInt("money")));
        return user;
    }
}
