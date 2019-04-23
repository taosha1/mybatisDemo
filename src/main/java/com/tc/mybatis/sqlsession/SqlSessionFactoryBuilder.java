package com.tc.mybatis.sqlsession;

import com.tc.mybatis.cfg.Configuration;
import com.tc.mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import com.tc.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/*
* 创建一个SqlSessionFactory对象
* */
public class SqlSessionFactoryBuilder {



    public SqlSessionFactory build(InputStream config){

        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new SqlSessionFactoryImpl(cfg);
    }
}
