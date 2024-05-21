package com.myportfolio.web.service;

import com.myportfolio.web.domain.Boards;
import com.myportfolio.web.domain.SearchCondition;
import com.myportfolio.web.repository.BoardsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardsService {
    @Autowired
    BoardsDao boardsDao;

    public int getCount() throws Exception {
        return boardsDao.count();
    }

    public int remove(Integer bid, String user_id) throws Exception {
        return boardsDao.delete(bid, user_id);
    }

    public int write(Boards boardsDto) throws Exception {
        return boardsDao.insert(boardsDto);
    }

    public List<Boards> getList() throws Exception {
        return boardsDao.selectAll();
    }

    public Boards read(Integer bid) throws Exception {
        Boards boardDto = boardsDao.select(bid);
        boardsDao.increaseViewCnt(bid);

        return boardDto;
    }

    public List<Boards> getPage(Map map) throws Exception {
        return boardsDao.selectPage(map);
    }

    public int modify(Boards boardDto) throws Exception {
        return boardsDao.update(boardDto);
    }

    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return boardsDao.searchResultCnt(sc);
    }

    public List<Boards> getSearchResultPage(SearchCondition sc) throws Exception {
        return boardsDao.searchSelectPage(sc);
    }

}
