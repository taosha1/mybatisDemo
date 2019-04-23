package com.tc.mybatis.sqlsession.impl;

import com.tc.mybatis.cfg.Configuration;
import com.tc.mybatis.sqlsession.SqlSession;
import com.tc.mybatis.sqlsession.SqlSessionFactory;
//SqlSessionFactory实现类
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
