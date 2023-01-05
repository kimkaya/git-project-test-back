package com.example.web.controller;

import com.example.web.entity.Board;
import com.example.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @Autowired
    HttpSession session;

    @GetMapping("/user/profile")
    public ResponseEntity<Boolean> isProfile() {
        ResponseEntity<Boolean> res = null;
        String userid = (String)session.getAttribute("userid");
        if(userid != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
    }

    @PostMapping("/board/upload")
    public ResponseEntity<String> writeboard(@PathVariable("userid") String userid,
                                             @PathVariable("type") int type,
                                             @RequestParam("industry") String industry,
                                             @RequestParam("subject") String subject,
                                             @RequestParam("content") String content,
                                             @RequestParam("anonymous") Boolean anonymous) {
        ResponseEntity<String> res = null;
        try{
            boardService.writeBoard(new Board
                    (null, userid, type, industry, subject, content, anonymous));
            res = new ResponseEntity<String>(HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PostMapping("/offerboard/upload")
    public ResponseEntity<String> writeboard2(@PathVariable("userid") String userid,
                                             @PathVariable("type") int type,
                                             @RequestParam("industry") String industry,
                                             @RequestParam("subject") String subject,
                                             @RequestParam("content") String content,
                                             @RequestParam("anonymous") Boolean anonymous) {
        ResponseEntity<String> res = null;
        try{
            boardService.writeBoard2(new Board
                    (null, userid, type, industry, subject, content, anonymous));
            res = new ResponseEntity<String>(HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PostMapping("/officeboard/upload")
    public ResponseEntity<String> writeboard3(@PathVariable("userid") String userid,
                                             @PathVariable("type") int type,
                                             @RequestParam("industry") String industry,
                                             @RequestParam("subject") String subject,
                                             @RequestParam("content") String content,
                                             @RequestParam("anonymous") Boolean anonymous) {
        ResponseEntity<String> res = null;
        try{
            boardService.writeBoard3(new Board
                    (null, userid, type, industry, subject, content, anonymous));
            res = new ResponseEntity<String>(HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @PutMapping("/boardview/")
    public ResponseEntity<String> view(@RequestParam("subject") String subject,
                                       @RequestParam("content") String content, Integer postid){
        ResponseEntity<String> res = null;
        try{
            boardService.Boardview(postid, subject, content);
            res = new ResponseEntity<String>("게시판 글 수정 성공", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return  null;
    }

    @PutMapping("/delete/")
    public ResponseEntity<Integer> delete(@PathVariable Integer postid,
                                          @PathVariable String userid) {
        ResponseEntity<Integer> res = null;
        System.out.println(userid);
        try{
            Integer msgno = boardService.deleteBoard(postid, userid);
            res = new ResponseEntity<Integer>(msgno, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}

