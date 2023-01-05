package com.example.web.controller;
import com.example.web.entity.Comment;
import com.example.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    HttpSession session;


    @PostMapping("/boarddetail/comment/upload")
    public ResponseEntity<String> writeComment(@PathVariable("userid") String userid,
                                               @PathVariable("type") int type,
                                               @RequestParam("comment") String comment,
                                               @RequestParam("anonymous") Boolean anonymous) {
        ResponseEntity<String> res = null;
        try{
            commentService.writeComment(new Comment
                    (null, userid, type, comment, anonymous));
            res = new ResponseEntity<String>(HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}
