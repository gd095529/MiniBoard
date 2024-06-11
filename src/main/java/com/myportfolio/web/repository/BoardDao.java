package com.myportfolio.web.repository;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.myportfolio.web.repository.BoardMapper.";
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)

    public int countCnt(Integer bid) throws Exception {
        return session.selectOne(namespace+"countCnt", bid);
    }

    public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    } // int delete(String statement)

    public int delete(Integer bid, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bid", bid);
        map.put("writer", writer);
        return session.delete(namespace+"delete", map);
    } // int delete(String statement, Object parameter)

    
    public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    } // int insert(String statement, Object parameter)

    
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    } // List<E> selectList(String statement)

    
    public BoardDto select(Integer bid) throws Exception {
        return session.selectOne(namespace + "select", bid);
    } // T selectOne(String statement, Object parameter)

    
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    } // List<E> selectList(String statement, Object parameter)

    
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)

    
    public int increaseViewCnt(Integer bid) throws Exception {
        return session.update(namespace+"increaseViewCnt", bid);
    } // int update(String statement, Object parameter)

    
    public int searchResultCnt(SearchCondition sc) throws Exception {
//        System.out.println("sc in searchResultCnt() = " + sc);
//        System.out.println("session = " + session);
        return session.selectOne(namespace+"searchResultCnt", sc);
    } // T selectOne(String statement, Object parameter)

    
    public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    } // List<E> selectList(String statement, Object parameter)

    
    public int updateCommentCnt(Integer bid, int comment_cnt) {
        Map map = new HashMap();
        map.put("comment_cnt",comment_cnt);
        map.put("bid",bid);
        return session.update(namespace+"updateCommentCnt", map);
    }

    
    public List<BoardDto> selectVC(){
        return session.selectList(namespace+"selectVC");
    }

    
    public List<BoardDto> selectCC(){
        return session.selectList(namespace+"selectCC");
    }

    
    public List<BoardDto> selectDate(){
        return session.selectList(namespace+"selectDate");
    }
}
