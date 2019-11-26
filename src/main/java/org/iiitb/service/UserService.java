package org.iiitb.service;

import org.iiitb.bean.User;
import org.iiitb.dao.UserDao;

public interface UserService {
    UserDao userDao = new UserDao();

    User findByUserName(String userName);
}
