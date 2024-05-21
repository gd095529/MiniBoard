package com.myportfolio.web.service;

import com.myportfolio.web.domain.Comments;
import com.myportfolio.web.repository.CommentsDao;
import com.myportfolio.web.repository.BoardsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentsService {
//    @Autowired
    BoardsDao boardsDao;
//
//    @Autowired
    CommentsDao commentsDao;

//    @Autowired
    public CommentsService(CommentsDao commentsDao, BoardsDao boardsDao) {
        this.commentsDao = commentsDao;
        this.boardsDao = boardsDao;
    }

    public int getCount(Integer bid) throws Exception {
        return commentsDao.count(bid);
    }

    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer cid, Integer bid, Integer commenter) throws Exception {
        int rowCnt = boardsDao.updateCommentCnt(bid, -1);
//        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//        throw new Exception("test");
        rowCnt = commentsDao.delete(cid, commenter);
//        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Transactional(rollbackFor = Exception.class)
    public int write(Comments commentDto) throws Exception {
        boardsDao.updateCommentCnt(commentDto.getBoard_id(), 1);
//        throw new Exception("test");
        return commentsDao.insert(commentDto);
        //저장이되면 id발급 -> id불러와서 대입
//        return commentsDao.updatePcid(commentsDao.findLastId());
    }

    public List<Comments> getList(Integer bid) throws Exception {
//        throw new Exception("test");
        return commentsDao.selectAll(bid);
    }

    public Comments read(Integer cid) throws Exception {
        return commentsDao.select(cid);
    }

    public int modify(Comments commentDto) throws Exception {
        return commentsDao.update(commentDto);
    }
}
