package com.myportfolio.web.repository;

import com.myportfolio.web.domain.Comments;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentsDao {

    @Autowired
    SqlSession session;

    String namespace = "com.myportfolio.web.repository.CommentsMapper.";

    public int count(Integer board_id) throws Exception{
        return session.selectOne(namespace+"count",board_id);
    }

    public int deleteAll(Integer board_id){
        return session.delete(namespace+"deleteAll",board_id);
    }

    public int delete(Integer id, Integer user_id) throws Exception {
        Map map = new HashMap();
        map.put("id", id);
        map.put("user_id", user_id);
        return session.delete(namespace+"delete", map);
    }

    public int insert(Comments dto) throws Exception{
        return session.insert(namespace+"insert", dto);
    }

    public List<Comments> selectAll(Integer board_id) throws Exception {
        return session.selectList(namespace+"selectAll", board_id);
    }

    public Comments select(Integer id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }

    public int update(Comments dto) throws Exception {
        return session.update(namespace+"update", dto);
    }

    public int findLastId() throws Exception{
        return session.selectOne(namespace+"findLastId");
    }
}
