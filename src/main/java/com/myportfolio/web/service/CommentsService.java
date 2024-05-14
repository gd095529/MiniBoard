package com.myportfolio.web.service;

import com.myportfolio.web.repository.CommentsDao;
import com.myportfolio.web.repository.PostsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentsService {
//    @Autowired
    PostsDao postsDao;
//
//    @Autowired
    CommentsDao commentsDao;

    public CommentsService(CommentsDao commentsDao, PostsDao postsDao) {
        this.commentsDao = commentsDao;
        this.postsDao = postsDao;
    }

    public int getCount(Integer bno) throws Exception {
        return commentsDao.count(bno);
    }


}
