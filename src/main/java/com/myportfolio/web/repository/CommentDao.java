package com.myportfolio.web.repository;

import com.myportfolio.web.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDao {

    @Autowired
    SqlSession session;

    String namespace = "com.myportfolio.web.repository.CommentMapper.";

    public int count(Integer bid) throws Exception {
        return session.selectOne(namespace+"count", bid);
    } // T selectOne(String statement)
    
    public int deleteAll(Integer bid) {
        return session.delete(namespace+"deleteAll", bid);
    } // int delete(String statement)

    
    public int delete(Integer cid, String commenter) throws Exception {
        Map map = new HashMap();
        map.put("cid", cid);
        map.put("commenter", commenter);
        return session.delete(namespace+"delete", map);
    } // int delete(String statement, Object parameter)

    
    public int insert(CommentDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    } // int insert(String statement, Object parameter)
    
    public List<CommentDto> selectAll(Integer bid) throws Exception {
//        System.out.println("bid3 = " + session.selectList(namespace+"selectAll", bid));
        return session.selectList(namespace+"selectAll", bid);
    } // List<E> selectList(String statement)

    
    public CommentDto select(Integer cid) throws Exception {
        return session.selectOne(namespace + "select", cid);
    } // T selectOne(String statement, Object parameter)

    
    public int update(CommentDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)
}
