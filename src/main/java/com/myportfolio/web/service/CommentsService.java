package com.myportfolio.web.service;

import com.myportfolio.web.domain.Comments;
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

    public int getCount(Integer id) throws Exception {
        return commentsDao.count(id);
    }

    public int writeDefault(Integer id) throws Exception{
        return commentsDao.updatePcid(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer cid, Integer pid, Integer commenter) throws Exception {
        int rowCnt = postsDao.updateCommentCnt(pid, -1);
//        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//        throw new Exception("test");
        rowCnt = commentsDao.delete(cid, commenter);
//        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Transactional(rollbackFor = Exception.class)
    public int write(Comments commentDto) throws Exception {
        postsDao.updateCommentCnt(commentDto.getPost_id(), 1);
//        throw new Exception("test");
        commentsDao.insert(commentDto);
        //저장이되면 id발급 -> id불러와서 대입
        return commentsDao.updatePcid(commentsDao.findLastId());
    }

    public List<Comments> getList(Integer pid) throws Exception {
//        throw new Exception("test");
        return commentsDao.selectAll(pid);
    }

    public Comments read(Integer cid) throws Exception {
        return commentsDao.select(cid);
    }

    public int modify(Comments commentDto) throws Exception {
        return commentsDao.update(commentDto);
    }
}
