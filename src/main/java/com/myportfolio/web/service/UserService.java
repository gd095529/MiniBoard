package com.myportfolio.web.service;

import com.myportfolio.web.domain.User;
import com.myportfolio.web.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User read(String email) throws Exception{
        return userDao.selectEmail(email);
    }

    public User read(Integer id) throws Exception{
        return userDao.select(id);
    }

    public int update(User user) throws Exception{
        return userDao.update(user);
    }

    public int insert(User user) throws Exception{
        return userDao.insert(user);
    }

    public int delete(Integer id)throws Exception{
        return userDao.delete(id);
    }



}
