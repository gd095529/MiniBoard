package com.myportfolio.web.repository;

import com.myportfolio.web.domain.Boards;
import com.myportfolio.web.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardsDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.myportfolio.web.repository.BoardsMapper.";

    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }

    public int delete(Integer id, String user_id) throws Exception{
        Map map = new HashMap();
        map.put("id",id);
        map.put("user_id",user_id);
        return session.delete(namespace+"delete", map);
    }

    public int insert(Boards dto) throws Exception{
        return session.insert(namespace+"insert", dto);
    }

    public List<Boards> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }

    public Boards select(Integer id) throws Exception{
        return session.selectOne(namespace+"select", id);
    }

    public List<Boards> selectPage(Map map) throws Exception{
        return session.selectList(namespace+"selectPage",map);
    }

    public int update(Boards dto) throws Exception{
        return session.update(namespace+"update",dto);
    }

    public int increaseViewCnt(Integer id) throws Exception{
        return session.update(namespace+"increaseViewCnt", id);
    }

    public int searchResultCnt(SearchCondition sc) throws Exception{
        return session.selectOne(namespace+"searchResultCnt",sc);
    }

    public List<Boards> searchSelectPage(SearchCondition sc) throws Exception{
        return session.selectList(namespace+"searchSelectPage",sc);
    }

    public int updateCommentCnt(Integer id, int cnt) {
        Map map = new HashMap();
        map.put("cnt",cnt);
        map.put("id",id);
        return session.update(namespace+"updateCommentCnt", map);
    }
}
