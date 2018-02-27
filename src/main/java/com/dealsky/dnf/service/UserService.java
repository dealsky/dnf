package com.dealsky.dnf.service;

import com.dealsky.dnf.dao.UserMapper;
import com.dealsky.dnf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {


    /**
     * 根据主键查找用户
     * @param key
     * @return
     */
    User findUserByPrimaryKey(Integer key);

}
