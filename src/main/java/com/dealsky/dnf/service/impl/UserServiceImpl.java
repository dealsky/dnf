package com.dealsky.dnf.service.impl;

import com.dealsky.dnf.dao.UserMapper;
import com.dealsky.dnf.pojo.User;
import com.dealsky.dnf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByPrimaryKey(Integer key) {
        return userMapper.selectByPrimaryKey(key);
    }
}
