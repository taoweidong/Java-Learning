package com.jdbc;

import com.alibaba.fastjson.JSON;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库连接.
 * https://www.cnblogs.com/smyhvae/p/4085684.html
 * @author taowd
 */
public class jdbcDemoDbUtils {

	public static void main(String[] args) throws SQLException {

		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner();

		// 第二步: 执行SQL
		String sql = "SELECT * FROM `t_test`";
		List<User> userList = qr.execute(DBUtils.getConnection(), sql,
				new BeanHandler<>(User.class));

		System.out.println(JSON.toJSON(userList));
	}
}
