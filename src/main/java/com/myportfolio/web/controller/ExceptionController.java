package com.myportfolio.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String lastCatcher(Exception ex, Model m){
        m.addAttribute("ex",ex);

        return "exceptionError";
    }
}
