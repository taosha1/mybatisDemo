package com.tc.mybatis.sqlsession.proxy;

import com.tc.mybatis.cfg.Mapper;
import com.tc.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名+方法名
    // value是sql语句
    private Map<String, Mapper> mappers;
    //
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    //用于对dao层接口方法进行增强
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        //找到方法声明类的名称
        String className = method.getDeclaringClass().getName();
        //注意此处拼接时的顺序，不要遗漏.
        String key = className+"."+methodName ;

        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传入参数有误");
        }
        //调用工具类查询所有
        return new Executor().selectList(mapper, connection);
    }
}
