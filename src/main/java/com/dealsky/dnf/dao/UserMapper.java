package com.dealsky.dnf.dao;

import com.dealsky.dnf.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer usernumber);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer usernumber);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}