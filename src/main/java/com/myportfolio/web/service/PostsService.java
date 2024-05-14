package com.myportfolio.web.service;

import com.myportfolio.web.domain.Posts;
import com.myportfolio.web.domain.SearchCondition;
import com.myportfolio.web.repository.PostsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostsService {
    @Autowired
    PostsDao postsDao;

    public int getCount() throws Exception {
        return postsDao.count();
    }

    public int remove(Integer id, String user_id) throws Exception {
        return postsDao.delete(id, user_id);
    }

    public int write(Posts posts) throws Exception {
        return postsDao.insert(posts);
    }

    public List<Posts> getList() throws Exception {
        return postsDao.selectAll();
    }

    public Posts read(Integer bno) throws Exception {
        Posts boardDto = postsDao.select(bno);
        postsDao.increaseViewCnt(bno);

        return boardDto;
    }

    public List<Posts> getPage(Map map) throws Exception {
        return postsDao.selectPage(map);
    }

    public int modify(Posts boardDto) throws Exception {
        return postsDao.update(boardDto);
    }

    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return postsDao.searchResultCnt(sc);
    }

    public List<Posts> getSearchResultPage(SearchCondition sc) throws Exception {
        return postsDao.searchSelectPage(sc);
    }


}
