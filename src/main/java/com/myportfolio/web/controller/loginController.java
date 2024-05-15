package com.myportfolio.web.controller;

import com.myportfolio.web.domain.User;
import com.myportfolio.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class loginController {
    @Autowired
    UserService userService;

//    @GetMapping("/login")
//    public String aboutLogin() throws Exception{
//
//        throw new Exception("예외발생");
//        return "index";
//    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String email, String pwd, String toURL, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. id와 pwd를 확인
        if(!loginCheck(email, pwd)) {
            // 2-1   일치하지 않으면, loginForm으로 이동
            String msg = URLEncoder.encode("email 또는 pwd가 일치하지 않습니다.", "UTF-8");

            return "redirect:/login/login?msg="+msg;
        }
        // 2-2. id와 pwd가 일치하면,
        int uid = userService.read(email).getId();
        //  세션 객체를 얻어오기
        HttpSession session = request.getSession();
        //  세션 객체에 id를 저장
        session.setAttribute("uid", uid);
        session.setAttribute("nick", userService.read(uid).getNickname());

        if(rememberId) {
            //     1. 쿠키를 생성
            Cookie cookie = new Cookie("email", email); // ctrl+shift+o 자동 import
//		       2. 응답에 저장
            response.addCookie(cookie);
        } else {
            // 1. 쿠키를 삭제
            Cookie cookie = new Cookie("email", email); // ctrl+shift+o 자동 import
            cookie.setMaxAge(0); // 쿠키를 삭제
//		       2. 응답에 저장
            response.addCookie(cookie);
        }
//		       3. 홈으로 이동
        toURL = toURL==null || toURL.equals("") ? "/" : toURL;

        return "redirect:"+toURL;
    }

    private boolean loginCheck(String email, String pwd) {
        User user = null;

        try {
            user = userService.read(email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return user!=null && user.getPassword().equals(pwd);
//        return "asdf".equals(id) && "1234".equals(pwd);
    }
}
