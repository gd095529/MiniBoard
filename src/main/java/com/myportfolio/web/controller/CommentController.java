package com.myportfolio.web.controller;

import com.myportfolio.web.domain.CommentDto;
import com.myportfolio.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class CommentController {
    @Autowired
    CommentService service;

    //    {
//        "pcid" : 0,
//            "comment" : "hihihi",
//            "commenter" : "aswe"
//    }
    //댓글을 수정하는 메서드
//    @ResponseBody
    @PatchMapping("/comments/{cid}")   // /comments/31 Pach
    public ResponseEntity<String> modify(@PathVariable Integer cid, @RequestBody CommentDto dto, HttpSession session) {
        String commenter = (String)session.getAttribute("uid");
//        String commenter = "aswe";
        dto.setCommenter(commenter);
        dto.setCid(cid);
        System.out.println("dto = " + dto);

        try {
            if(service.modify(dto)!=1)
                throw new Exception("mod fail");

            return new ResponseEntity<>("mod ok", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("mod err", HttpStatus.BAD_REQUEST);
        }
    }


//    {
//        "pcid" : 0,
//        "comment" : "hi"
//    }

    // 댓글을 등록하는 메서드
//    @ResponseBody
    @PostMapping("/comments")   // /comments?bid=644 POST
    public ResponseEntity<String> write(@RequestBody CommentDto dto, Integer bid, HttpSession session) {
        String commenter = (String)session.getAttribute("uid");
//        String commenter = "aswe";
        dto.setCommenter(commenter);
        dto.setBid(bid);
        System.out.println("dto = " + dto);

        try {
            if(service.write(dto)!=1)
                throw new Exception("write fail");

            return new ResponseEntity<>("write ok", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("write err", HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 댓글을 삭제하는 메서드
    @DeleteMapping("/comments/{cid}") // /comments/1?bid=644 <--- 삭제할 댓글 번호
//    @ResponseBody
    public ResponseEntity<String> remove(@PathVariable Integer cid, Integer bid, HttpSession session){
        String commenter = (String)session.getAttribute("uid");
//        String commenter = "aswe";

        try {
            int rowCnt = service.remove(cid, bid, commenter);

            if(rowCnt!=1){
                throw new Exception("delete fail");
            }
            return new ResponseEntity<>("del ok", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("del err", HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 게시물의 모든 댓글을 가져오는 메서드
    @GetMapping("/comments") // /comments?bid=100 GET
    @ResponseBody public ResponseEntity<List<CommentDto>> list(Integer bid){
        List<CommentDto> list = null;

        try {
//            System.out.println("bid1 = " + bid);
            list = service.getList(bid);
            System.out.println("list = " + list);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK); //200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST); //400
        }

    }
}
