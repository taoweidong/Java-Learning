package com.jdbc;

import java.sql.*;

public class DBUtils {

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

	private DBUtils() {

	}

	// 使用静态块加载驱动程序
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 定义一个获取数据库连接的方法
	 * @return
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS_WORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 * @param rs
	 * @param stat
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stat, Connection conn) {

		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
