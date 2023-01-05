package com.example.web.controller;
import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/")
    public String Login() {
        return "";
    }

    @GetMapping("register")
    public String registerForm() {
        return "auth/register";
    }

    @GetMapping("officeregister")
    public String officeregisterForm() {
        return "auth/officeregister";
    }

    @GetMapping("login")
    public String loginForm() {
        return "login";
    }


}
