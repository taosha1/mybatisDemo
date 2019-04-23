package com.tc.test;

import com.tc.dao.UserDao;
import com.tc.domain.User;
import com.tc.mybatis.io.Resources;
import com.tc.mybatis.sqlsession.SqlSession;
import com.tc.mybatis.sqlsession.SqlSessionFactory;
import com.tc.mybatis.sqlsession.SqlSessionFactoryBuilder;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    public static void main(String[] args) {

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> all = mapper.getAll();
        for (User u:all){
            System.out.println(u.toString());
        }
        try {
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
