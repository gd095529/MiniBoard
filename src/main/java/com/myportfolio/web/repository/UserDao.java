package com.myportfolio.web.repository;

import com.myportfolio.web.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
//    @Autowired
//    DataSource ds;

    @Autowired
    SqlSession session;

    String namespace = "com.myportfolio.web.repository.UserMapper.";
    public User select(Integer id) throws Exception {
        return session.selectOne(namespace+"selectOne", id);
    }

    public User selectEmail(String email) throws Exception{
        return session.selectOne(namespace+"selectEmail",email);
    }
    public int insert(User user) throws Exception{
        return session.insert(namespace+"insert", user);
    }

    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    public int delete(Integer id) throws Exception{
        return session.delete(namespace+"delete", id);
    }

    public int update(User user) throws Exception{
        return session.update(namespace+"update",user);
    }

    public int countUser() throws Exception{
        return session.selectOne(namespace+"count");
    }

    public List<User> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

}
