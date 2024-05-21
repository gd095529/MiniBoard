package com.myportfolio.web.controller;


import com.myportfolio.web.domain.User;
import com.myportfolio.web.repository.UserDao;
import com.myportfolio.web.service.UserValidator;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping("/add")
    public String addUser() {return "registerForm";}

    @InitBinder
    public void toDate(WebDataBinder binder){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
        binder.setValidator(new UserValidator());
    }

    @PostMapping("/add")
    public String saveUser(@Valid User user, BindingResult result) throws Exception {
        System.out.println("result="+result);
        System.out.println("user="+user);

        // User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야 함.
        if(!result.hasErrors()) {
            // 2. DB에 신규회원 정보를 저장
            int rowCnt = userService.insert(user);

            if(rowCnt!= 0)
                return "registerInfo";
        }

        return "registerForm";
    }

    @GetMapping("/update")
    public String updateUser(User user){

        return "registerUpdate";
    }

    @PostMapping("/update")
    public String updateSaveUser(User user) {
        try {
            userService.update(user);
        }catch (Exception e){
            e.printStackTrace();
            return "registerUpdate";
        }

        return "registerInfo";
    }

    @PostMapping("/delete")
    public String deleteUser(String uid) {
        try {
            userService.delete(uid);
        }catch (Exception e){
            e.printStackTrace();
            return "registerInfo";
        }

        return "/";
    }

}
