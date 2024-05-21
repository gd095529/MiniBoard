package com.myportfolio.web.service;

import com.myportfolio.web.domain.CommentDto;
import com.myportfolio.web.repository.CommentDao;
import com.myportfolio.web.repository.BoardDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
//    @Autowired
    BoardDao boardDao;
//
//    @Autowired
    CommentDao commentDao;

//    @Autowired
    public CommentService(CommentDao commentDao, BoardDao boardDao) {
        this.commentDao = commentDao;
        this.boardDao = boardDao;
    }

    
    public int getCount(Integer bid) throws Exception {
        return commentDao.count(bid);
    }

    
    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer cid, Integer bid, String commenter) throws Exception {
        int rowCnt = boardDao.updateCommentCnt(bid, -1);
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
//        throw new Exception("test");
        rowCnt = commentDao.delete(cid, commenter);
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    
    @Transactional(rollbackFor = Exception.class)
    public int write(CommentDto commentDto) throws Exception {
        boardDao.updateCommentCnt(commentDto.getBid(), 1);
//                throw new Exception("test");
        return commentDao.insert(commentDto);
    }

    
    public List<CommentDto> getList(Integer bid) throws Exception {
//        throw new Exception("test");
//        System.out.println("bid2 = " + commentDao.selectAll(bid));
        return commentDao.selectAll(bid);
    }

    
    public CommentDto read(Integer cid) throws Exception {
        return commentDao.select(cid);
    }

    
    public int modify(CommentDto commentDto) throws Exception {
        return commentDao.update(commentDto);
    }
}
