package com.donghua;

import com.donghua.entity.RowsMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils {

    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;

    static {
        driverClass = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://192.168.88.128:3306/taowd_db";
        user = "root";
        password = "root";

        /**
         * 驱动注册
         */
        try {
            Class.forName(driverClass);//注册加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 Connetion
     *
     * @return
     * @throws SQLException
     */

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭ResultSet资源
     *
     * @param rs
     */

    public static void close(ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭Statement资源
     *
     * @param stmt
     */

    public static void close(Statement stmt) {
        if (null != stmt) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭close资源
     *
     * @param conn
     */
    public static void close(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     *
     * @param rs
     * @param stmt
     * @param conn
     */

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        close(rs);
        close(stmt);
        close(conn);
    }

    /**
     * insert方法
     *
     * @param conn
     * @param sql
     * @param parems
     * @return
     * @throws SQLException
     */
    public static int insert(Connection conn, String sql, Object[] parems) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            if (null != parems && parems.length > 0) {//判断是否有信息增加
                for (int i = 0; i < parems.length; i++) {
                    stmt.setObject(i + 1, parems[i]);//使用给定对象设置指定参数的值
                }
            }
            int count = stmt.executeUpdate();

            return count;
        } finally {
            close(stmt);
        }
    }

    /**
     * 泛型查询方法
     *
     * @param conn
     * @param sql
     * @param paramsList
     * @param rm
     * @return
     * @throws SQLException
     */
    public static <T> List<T> executeQuery(Connection conn, String sql, Object[] paramsList, RowsMapper<T> rm) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            stmt = conn.prepareStatement(sql);
            if (null != paramsList && paramsList.length > 0) {//判断是否有信息增加
                for (int i = 0; i < paramsList.length; i++) {
                    stmt.setObject(i + 1, paramsList[i]);
                }
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                T t = rm.getEntity(rs);
                list.add(t);
            }
            return list;
        } finally {
            close(rs);
            close(stmt);
        }
    }

}
