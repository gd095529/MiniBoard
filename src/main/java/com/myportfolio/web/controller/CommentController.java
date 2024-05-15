package com.myportfolio.web.controller;

import com.myportfolio.web.domain.Comments;
import com.myportfolio.web.service.CommentsService;
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
    CommentsService service;

//    {
//        "pcno" : 0,
//            "comment" : "hihihi",
//            "commenter" : "aswe"
//    }
    //댓글을 수정하는 메서드
//    @ResponseBody
    @PatchMapping("/comments/{cid}")   // /comments/31 Patch
    public ResponseEntity<String> modify(@PathVariable Integer cid, @RequestBody Comments dto, HttpSession session) {
        int commenter = (Integer) session.getAttribute("uid");
//        String commenter = "aswe";
        dto.setUser_id(commenter);
        dto.setId(cid);
//        System.out.println("dto = " + dto);

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
//        "pcno" : 0,
//        "comment" : "hi"
//    }

    // 댓글을 등록하는 메서드
//    @ResponseBody
    @PostMapping("/comments")   // /comments?bid=644 POST
    public ResponseEntity<String> write(@RequestBody Comments dto, Integer pid, HttpSession session) {
        int commenter = (Integer) session.getAttribute("uid");
//        String commenter = "aswe";
        dto.setUser_id(commenter);
        dto.setPost_id(pid);
//        System.out.println("dto = " + dto);

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
    @DeleteMapping("/comments/{cid}") // /comments/1?bno=644 <--- 삭제할 댓글 번호
//    @ResponseBody
    public ResponseEntity<String> remove(@PathVariable Integer cid, Integer pid, HttpSession session){
        int commenter = (Integer) session.getAttribute("uid");
//        String commenter = "aswe";

        try {
            int rowCnt = service.remove(cid, pid, commenter);

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
    @GetMapping("/comments") // /comments?bno=100 GET
    @ResponseBody public ResponseEntity<List<Comments>> list(Integer pid){
        List<Comments> list = null;

        try {
            list = service.getList(pid);
//            System.out.println("list = " + list);
            return new ResponseEntity<List<Comments>>(list, HttpStatus.OK); //200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Comments>>(HttpStatus.BAD_REQUEST); //400
        }

    }
}
