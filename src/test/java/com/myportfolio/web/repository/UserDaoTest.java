package com.myportfolio.web.repository;

import com.myportfolio.web.dbset.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void updateUserTest() throws Exception {
        userDao.deleteAllUser();
        User user = new User("asdf","asdf",null,"asdf","asdf");
        userDao.insertUser(user);
        User user2 = userDao.selectUser("asdf");
        int cnt = userDao.updateUser(new User("asdf","1234",null,"qwer","zxcv"));
        assertTrue(cnt != 0);
    }
    @Test
    public void CountUser() throws Exception {
        userDao.deleteAllUser();
        int cnt = 0;
        User user = new User("asdf","asdf",null,"asdf","asdf");
        userDao.insertUser(user);
        cnt = userDao.countUser();
        assertTrue(cnt==1);
    }

    @Test
    public void deleteAllUserTest() throws Exception {
        userDao.deleteAllUser();
        User user = new User("asdf","asdf",null,"asdf","asdf");
        userDao.insertUser(user);
        assertTrue(userDao.countUser()==1);
        userDao.deleteAllUser();

        assertTrue(userDao.countUser()==0);
    }

    @Test
    public void insertUserTest() throws Exception{
        userDao.deleteAllUser();
        User user = new User("test","1234",null,"newone","aaa@naver.com");
        int rowCnt = userDao.insertUser(user);

        assertTrue(rowCnt!=0);
    }

    @Test
    public void selectUserTest() throws Exception {
        userDao.deleteAllUser();
        User user = new User("gd095529","asdf",null,"asdf","asdf");
        userDao.insertUser(user);
        User user1 = userDao.selectUser("gd095529");

        assertTrue(user1.getId().equals("gd095529"));
    }
}