package com.myportfolio.web.service;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.SearchCondition;
import com.myportfolio.web.repository.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    BoardDao boardDao;

    
    public int getCount() throws Exception {
        return boardDao.count();
    }

    
    public int remove(Integer bid, String writer) throws Exception {
        return boardDao.delete(bid, writer);
    }

    
    public int write(BoardDto boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }

    
    public List<BoardDto> getList() throws Exception {
        return boardDao.selectAll();
    }

    
    public BoardDto read(Integer bid) throws Exception {
        BoardDto boardDto = boardDao.select(bid);
        boardDao.increaseViewCnt(bid);

        return boardDto;
    }

    
    public List<BoardDto> getPage(Map map) throws Exception {
        return boardDao.selectPage(map);
    }

    
    public int modify(BoardDto boardDto) throws Exception {
        return boardDao.update(boardDto);
    }

    
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return boardDao.searchResultCnt(sc);
    }

    
    public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception {
        return boardDao.searchSelectPage(sc);
    }

    
    public List<BoardDto> list_VT5() throws Exception {
        return boardDao.selectVC();
    }

    
    public List<BoardDto> list_CT5() throws Exception {
        return boardDao.selectCC();
    }

    
    public List<BoardDto> list_D5() throws Exception {
        return boardDao.selectDate();
    }
}
