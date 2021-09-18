package com.jdbc;

import java.sql.*;

/**
 * 数据库连接. https://www.runoob.com/java/java-mysql-connect.html
 * 
 * @author taowd
 */
public class JdbcDemo01 {

    /**
     * JDBC驱动
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 数据库连接.
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    /**
     * 数据库账号.
     */
    static final String USER = "root";

    /**
     * 数据库密码.
     */
    static final String PASS_WORD = "root";

    /**
     * 启动类.
     * 
     * @param args
     *            参数
     */
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            // 注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库........");
            connection = DriverManager.getConnection(DB_URL, USER, PASS_WORD);

            // 执行查询
            System.out.println("实例化Statement对象.........");
            statement = connection.createStatement();

            String sql = "SELECT * FROM `t_test`";
            ResultSet resultSet = statement.executeQuery(sql);

            // 展开结果集
            while (resultSet.next()) {
                // 通过字段检索
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");

                // 输出数据
                System.out.println("id=" + id + "-----" + "Name=" + name + "-----" + "Age=" + age);
            }

            // 完成后关闭
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException se2) {
            } // 什么都不做
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
