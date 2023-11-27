package com.myportfolio.web.repository;

import com.myportfolio.web.dbset.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    DataSource ds;

    @Autowired
    SqlSession session;

    String namespace = "com.myportfolio.web.repository.UserMapper.";
//    public User select(String id) throws Exception {
//        return session.select(namespace+"select", id);
//    }

    public int updateUser(User user) throws Exception {
        String sql = "update user_info set pwd = ? , birth =? , name=?, email=? where id = ?";
        int rowCnt = 0;
        try(
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1, user.getPwd());
            pstmt.setDate(2, (java.sql.Date) user.getBirth());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getId());

            rowCnt = pstmt.executeUpdate();
        }
        return rowCnt;
    }

    public int countUser() throws Exception {
        String sql = "select count(*) from user_info ";
        int cnt = 0;
        try(
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                ){
            rs.next();
            cnt = rs.getInt(1);
        }
        return cnt;
    }

    public int deleteAllUser() throws Exception {
        String sql = "delete from user_info ";
        int rowCnt = 0;
        try(
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            rowCnt = pstmt.executeUpdate();
        }
        return rowCnt;
    }

    public int insertUser(User user) throws Exception{
        String sql = "insert into user_info values(?,?,?,?,?) ";
        int rowCnt = 0;

        try(
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1,user.getId());
            pstmt.setString(2,user.getPwd());
            pstmt.setDate(3, (java.sql.Date) user.getBirth());
            pstmt.setString(4,user.getName());
            pstmt.setString(5,user.getEmail());

            rowCnt = pstmt.executeUpdate();
        }
        return rowCnt;
    }

    public User selectUser(String id) throws Exception {
        User user = null;
        String sql = "select * from user_info where id= ? ";
        try(
                Connection con = ds.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getString("id"));
                user.setPwd(rs.getString("pwd"));
                user.setBirth((java.sql.Date)rs.getDate("birth"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        }
        return user;
    }



}
