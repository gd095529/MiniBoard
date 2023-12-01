package com.myportfolio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String lastCatcher(Exception ex, Model m){
        m.addAttribute("ex",ex);

        return "exceptionError";
    }
}
