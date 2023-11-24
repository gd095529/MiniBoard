package com.myportfolio.web.repository;

import com.myportfolio.web.dbset.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

@Repository
public class UserDao {
    @Autowired
    DataSource ds;

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
                user.setBirth(new Date(rs.getDate("birth").getDate()));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        }

        return user;
    }



}
