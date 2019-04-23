package com.tc.dao;

import com.tc.domain.User;
import com.tc.mybatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from user")
    List<User> getAll();

}
