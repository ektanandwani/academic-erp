package org.iiitb.service.impl;

import org.iiitb.bean.User;
import org.iiitb.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findByUserName(String userName) {
        System.out.println("calling service");
        return userDao.findByUserName(userName);
    }
}
