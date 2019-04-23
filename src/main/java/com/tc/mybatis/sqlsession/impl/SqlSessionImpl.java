package com.tc.mybatis.sqlsession.impl;

import com.tc.mybatis.cfg.Configuration;
import com.tc.mybatis.sqlsession.SqlSession;
import com.tc.mybatis.sqlsession.proxy.MapperProxy;
import com.tc.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlSessionImpl implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    //创建代理对象
    public <T> T getMapper(Class<T> daoInterfaceClass) {
         return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass} ,
                new MapperProxy(cfg.getMappers(),connection));
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
