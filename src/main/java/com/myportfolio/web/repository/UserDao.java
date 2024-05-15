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

//
//    public int updateUser(User user) throws Exception {
//        String sql = "update user_info set pwd = ? , birth =? , name=?, email=? where id = ?";
//        int rowCnt = 0;
//        try(
//                Connection con = ds.getConnection();
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ){
//            pstmt.setString(1, user.getPwd());
//            pstmt.setDate(2, (java.sql.Date) user.getBirth());
//            pstmt.setString(3, user.getName());
//            pstmt.setString(4, user.getEmail());
//            pstmt.setString(5, user.getId());
//
//            rowCnt = pstmt.executeUpdate();
//        }
//        return rowCnt;
//    }
//
//    public int countUser() throws Exception {
//        String sql = "select count(*) from user_info ";
//        int cnt = 0;
//        try(
//                Connection con = ds.getConnection();
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ResultSet rs = pstmt.executeQuery();
//                ){
//            rs.next();
//            cnt = rs.getInt(1);
//        }
//        return cnt;
//    }
//
//    public int deleteAllUser() throws Exception {
//        String sql = "delete from user_info ";
//        int rowCnt = 0;
//        try(
//                Connection con = ds.getConnection();
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ){
//            rowCnt = pstmt.executeUpdate();
//        }
//        return rowCnt;
//    }
//
//    public int insertUser(User user) throws Exception{
//        String sql = "insert into user_info values(?,?,?,?,?) ";
//        int rowCnt = 0;
//
//        try(
//                Connection con = ds.getConnection();
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ){
//            pstmt.setString(1,user.getId());
//            pstmt.setString(2,user.getPwd());
//            pstmt.setDate(3, (java.sql.Date) user.getBirth());
//            pstmt.setString(4,user.getName());
//            pstmt.setString(5,user.getEmail());
//
//            rowCnt = pstmt.executeUpdate();
//        }
//        return rowCnt;
//    }
//
//    public User selectUser(String id) throws Exception {
//        User user = null;
//        String sql = "select * from user_info where id= ? ";
//        try(
//                Connection con = ds.getConnection();
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ){
//            pstmt.setString(1,id);
//            ResultSet rs = pstmt.executeQuery();
//            if(rs.next()){
//                user = new User();
//                user.setId(rs.getString("id"));
//                user.setPwd(rs.getString("pwd"));
//                user.setBirth((java.sql.Date)rs.getDate("birth"));
//                user.setName(rs.getString("name"));
//                user.setEmail(rs.getString("email"));
//            }
//        }
//        return user;
//    }



}
