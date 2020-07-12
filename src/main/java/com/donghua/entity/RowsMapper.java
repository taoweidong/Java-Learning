package com.donghua.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 转换为行对象的接口
 *
 * @param <T>
 */
public interface RowsMapper<T> {
    public T getEntity(ResultSet rs) throws SQLException;

}