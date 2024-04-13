package com.myportfolio.web.repository;

import com.myportfolio.web.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    LocalDateTime date = LocalDateTime.now();
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
        User user = new User(null,"test","1234","ntest","test@email.com", date, date);
        userDao.insert(user);
        assertTrue(userDao.countUser()==1);
        userDao.deleteAll();

        assertTrue(userDao.countUser()==0);
    }

    @Test
    public void insertUserTest() throws Exception{
        userDao.deleteAll();
        User user = new User(null, "insertTest", "1234", "ntest", "test@email.com", date, date);

        int rowCnt =userDao.insert(user);

        assertTrue(userDao.select("insertTest").getPassword().equals("1234"));
        assertTrue(rowCnt!=0);
    }

    @Test
    public void selectUserTest() throws Exception {
        userDao.deleteAll();
        User user = new User(null,"test","1234","ntest","test@email.com", date,date);
        userDao.insert(user);
        User user1 = userDao.select("test");
        System.out.println("username=" +user1.getUsername());
        assertTrue(user1.getUsername().equals("test"));
    }

    @Test
    public void countAll() throws Exception{
        userDao.deleteAll();
        int num = userDao.countUser();
        assertTrue(userDao.selectAll().stream().count()==0);
        User user = new User(null,"test1","1234","test1","test@email.com", date,date);
        userDao.insert(user);
        User user1 = new User(null,"test2","1234","test2","test@email.com", date,date);
        userDao.insert(user1);
        assertTrue(userDao.selectAll().stream().count()==2);
    }
}