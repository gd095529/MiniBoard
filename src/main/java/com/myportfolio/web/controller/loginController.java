package com.myportfolio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/login")
    public String aboutLogin() throws Exception{

        throw new Exception("예외발생");
//        return "index";
    }

}
