package com.myportfolio.web.service;

import com.myportfolio.web.domain.User;
import com.myportfolio.web.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User read(String id) throws Exception{
        return userDao.selectUser(id);
    }

    public int update(User user) throws Exception{
        return userDao.updateUser(user);
    }

    public int insert(User user) throws Exception{
        return userDao.insertUser(user);
    }

    public int delete(String id)throws Exception{
        return userDao.deleteUser(id);
    }



}
