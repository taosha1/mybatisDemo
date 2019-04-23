package com.tc.dao;

import com.tc.domain.User;

import java.util.List;

public interface UserDao {

//    @Select("select * from user")
    List<User> getAll();

}
