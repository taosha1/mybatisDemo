package com.tc.mybatis.sqlsession;

/*
* 可以创建dao接口的代理对象
* */
public interface SqlSession {
    /*
    * 根据参数创建一个代理对象
    * 参数为 dao的接口字节码
    * */
    <T> T getMapper(Class<T> daoInterfaceClass);
    //释放资源
    void close();
}
