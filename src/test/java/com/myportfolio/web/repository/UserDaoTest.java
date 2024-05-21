package com.myportfolio.web.repository;

import com.myportfolio.web.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    Date date = new java.util.Date(1998,04,02);
//    @Test
//    public void updateUserTest() throws Exception {
//        userDao.deleteAllUser();
//        User user = new User("asdf","asdf",null,"asdf","asdf");
//        userDao.insertUser(user);
//        User user2 = userDao.selectUser("asdf");
//        int cnt = userDao.updateUser(new User("asdf","1234",null,"qwer","zxcv"));
//        assertTrue(cnt != 0);
//    }
//    @Test
//    public void CountUser() throws Exception {
//        userDao.deleteAllUser();
//        int cnt = 0;
//        User user = new User("asdf","asdf",null,"asdf","asdf");
//        userDao.insertUser(user);
//        cnt = userDao.countUser();
//        assertTrue(cnt==1);
//    }
//
    @Test
    public void deleteAllUserTest() throws Exception {
        userDao.deleteAll();
        User user = new User("test","1234","ntest","test@email.com", date, date);
        userDao.insertUser(user);
        assertTrue(userDao.count()==1);
        userDao.deleteAll();

        assertTrue(userDao.count()==0);
    }

    @Test
    public void insertUserTest() throws Exception{
        userDao.deleteAll();
        User user = new User("insertTest", "1234", "ntest", "test@email.com", date, date);

        int rowCnt =userDao.insertUser(user);

        assertTrue(userDao.selectUser("insertTest").getPwd().equals("1234"));
        assertTrue(rowCnt!=0);
    }

    @Test
    public void selectUserTest() throws Exception {
        userDao.deleteAll();
        User user = new User("test","1234","ntest","test@email.com", date,date);
        userDao.insertUser(user);
        User user1 = userDao.selectUser("test");
        System.out.println("username=" +user1.getName());
        assertTrue(user1.getName().equals("test"));
    }

    @Test
    public void updateUserTest() throws Exception{
        userDao.deleteAll();
        User user = new User("insertTest", "1234", "ntest", "test@email.com", date, date);
        userDao.insertUser(user);

        User user1 = userDao.selectUser("insertTest");
        user1.setPwd("asdf");
        int check = userDao.updateUser(user1);
        assertTrue(check==1);
        assertTrue(userDao.selectUser("insertTest").getPwd().equals("asdf"));

    }

//    @Test
//    public void countAll() throws Exception{
//        userDao.deleteAll();
//        int num = userDao.count();
//        assertTrue(userDao.selectAll().stream().count()==0);
//        User user = new User(null,"test1","1234","test1","test1@email.com", date,date);
//        userDao.insert(user);
//        User user1 = new User(null,"test2","1234","test2","test2@email.com", date,date);
//        userDao.insert(user1);
//        assertTrue(userDao.selectAll().stream().count()==2);
//    }
}