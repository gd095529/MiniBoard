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
    public void selectUserTest() throws Exception {
        User user = userDao.selectUser("gd095529");

        assertTrue(user.getId().equals("gd095529"));
    }
}