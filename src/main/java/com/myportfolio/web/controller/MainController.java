package com.myportfolio.web.controller;

import com.myportfolio.web.domain.BoardDto;
import com.myportfolio.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String list3(Model m){
        try {
            List<BoardDto> list_vt = boardService.list_VT5();
            List<BoardDto> list_ct = boardService.list_CT5();
            List<BoardDto> list_d = boardService.list_D5();
            m.addAttribute("list_vt", list_vt);
            m.addAttribute("list_ct", list_ct);
            m.addAttribute("list_d", list_d);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        }catch (Exception e){
            e.printStackTrace();
            m.addAttribute("msg","list err");
        }
        return "index";
    }
}
