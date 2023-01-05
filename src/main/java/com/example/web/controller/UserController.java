package com.example.web.controller;

import com.example.web.dto.UserLoginDTO;
import com.example.web.dto.UserSaveDTO;
import com.example.web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    HttpSession session;

    @PostMapping("register")
    public String register(@ModelAttribute UserSaveDTO userSaveDTO) {
        String userid = userService.register(userSaveDTO);
        return "auth/login";
    }

    @PostMapping("officeregister")
    public String officeregister(@ModelAttribute UserSaveDTO userSaveDTO) {
        String userid = userService.officeregister(userSaveDTO);
        return "auth/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute UserLoginDTO userLoginDTO, HttpSession session) {
        if (userService.login(userLoginDTO)) {
            session.setAttribute("loginId",userLoginDTO.getUserid());
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @GetMapping("/auth")
    public ResponseEntity<Boolean> isAuth() {
        ResponseEntity<Boolean> res = null;
        String userid = (String)session.getAttribute("userid");
        if(userid != null) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
    }

//    @PostMapping("register/SignUp")
//    public ResponseEntity<String> register(User us) {
//        ResponseEntity<String> res = null;
//        try{
//            userService.register(us);
//            res = new ResponseEntity<String>("success", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//        }
//        return res;
//    }

    @PostMapping("/register/checkId")
    public ResponseEntity<Boolean> checkId(@RequestParam("id") String userid) {
        ResponseEntity<Boolean> res = null;
        System.out.println(userid);
        try {
            Boolean isDouble = userService.checkDoubleId(userid);
            if(isDouble==false)
                res = new ResponseEntity<Boolean>(isDouble, HttpStatus.BAD_REQUEST);
            else
                res = new ResponseEntity<Boolean>(isDouble, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }

//    @PostMapping("/officeregister/SignUp")
//    public ResponseEntity<String> officeregister(User us) {
//        ResponseEntity<String> res = null;
//        try{
//            userService.officeregister(us);
//            res = new ResponseEntity<String>("success", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            res = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//        }
//        return res;
//    }

    @PostMapping("/officeregister/checkId/")
    public ResponseEntity<Boolean> officecheckId(@RequestParam("id") String userid) {
        ResponseEntity<Boolean> res = null;
        System.out.println(userid);
        try {
            Boolean isDouble = userService.checkDoubleId(userid);
            if(isDouble==false)
                res = new ResponseEntity<Boolean>(isDouble, HttpStatus.BAD_REQUEST);
            else
                res = new ResponseEntity<Boolean>(isDouble, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}
