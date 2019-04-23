package com.tc.mybatis.io;

import java.io.InputStream;

/*
 * 使用类加载器读取配置文件的类
 * */
public class Resources {

    /*
    *
    * 根据传入的参数获取字节输入流
    * */
    public static InputStream getResourceAsStream(String filepath){

        return Resources.class.getClassLoader().getResourceAsStream(filepath);

    }
}
