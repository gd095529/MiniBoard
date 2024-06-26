package com.myportfolio.web.controller;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.domain.PageHandler;
import com.myportfolio.web.domain.SearchCondition;
import com.myportfolio.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/remove")
    public String remove(Integer bid, SearchCondition sc, Model m, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("uid");
        try {

            int rowCnt = boardService.remove(bid, writer);
            if(rowCnt!=1)
                throw new Exception("board remove err");

            rattr.addFlashAttribute("msg", "DEL_OK");

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }

        return "redirect:/board/list"+sc.getQueryString(); //model에 담아서 자동으로 뒤에 ?page=page&pageSize=pageSize가 붙음
        //2페이지 삭제 했을때 2페이지로 안감 -> 가는데???
        //근디 왜 안되지 -> post때문인가 싶기도했지만 어짜피 redirect시 get으로 변경됨
    }

    @PostMapping("/modify")
    public String modify(Integer page, Integer pageSize, BoardDto boardDto, Model m/*객체 바로뒤에*/, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("uid");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.modify(boardDto);

            if(rowCnt!=1){
                throw new Exception("MOD_FAIL");
            }

            rattr.addFlashAttribute("msg","MOD_OK");
            rattr.addAttribute("page",page);
            rattr.addAttribute("pageSize",pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("BoardDto",boardDto);
            m.addAttribute("msg","MOD_ERR");
            return "board";
        }

        return "redirect:/board/list";//?page="+page+"&pageSize="+pageSize
    }

    @GetMapping("/write")
    public String write(Model m){
        m.addAttribute("mode", "new");
        return "/board";    //읽기, 쓰기에 사용 쓰=new
    }
    @PostMapping("/write")
    public String write(BoardDto boardDto, Model m/*객체 바로뒤에*/, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("uid");
        boardDto.setWriter(writer);

        try {
            int rowCnt = boardService.write(boardDto);

            if(rowCnt!=1){
                throw new Exception("WRT_FAIL");
            }

            rattr.addFlashAttribute("msg","WRT_OK");
            return "redirect:/board/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("BoardDto",boardDto);
            m.addAttribute("msg","WRT_ERR");
            return "board";
        }
    }

    @GetMapping("/read")
    public String read(Integer bid,SearchCondition sc, HttpServletRequest request, RedirectAttributes rattr, Model m){
        if(!loginCheck(request)) {
            request.getSession().invalidate();
            return "redirect:/login/login?toURL=" + request.getRequestURL()+"?bid="+bid;  // 로그인을 안했으면 로그인 화면으로 이동
        }
        try {
            BoardDto boardDto =boardService.read(bid);
//            m.addAttribute("boardDto",boardDto); //타입 앞문자를 소문자로 했을때 같으면 생략가능,아래와 같다
            m.addAttribute(boardDto);

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "READ_ERR");
            return "redirect:/board/list"+sc.getQueryString();
        }

        return "board";
    }

    @GetMapping("/list")
    public String list(@ModelAttribute SearchCondition sc, Model m , HttpServletRequest request) {
        if(!loginCheck(request)) {
            request.getSession().invalidate();
            return "redirect:/login/login?toURL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
        }

        try {
            int totalCnt = boardService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<BoardDto> list = boardService.getSearchResultPage(sc);
            m.addAttribute("list",list);
            m.addAttribute("ph",pageHandler);
            m.addAttribute("page",sc.getPage());
            m.addAttribute("pageSize",sc.getPageSize());

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg","list err");
            m.addAttribute("totalCnt",0);
        }

        m.addAttribute("SearchCondition",sc);

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    @GetMapping("/comments")
    @ResponseBody
    public int commentCnt(Integer bid) throws Exception{
        return boardService.getCnt(bid);
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 uid가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("uid")!=null;
    }
}