package com.example.controller;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toIndex")
    public String show() {
        return "index";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam/*("username")*/ String username, @RequestParam/*("password")*/ String password) {
        System.out.println("username:" + username + ", password:" + password);
        User user = userService.login(username, password);
        if (user != null) {
            //登录成功
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            attributes.getRequest().getSession().setAttribute("user", user);//将用户信息放入session
            return user.getRole();
        } else {
            return "loginError";
        }
    }

  /*  @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("role") String role) {
        try {
            userService.create(new User(username, password));
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            attributes.getRequest().getSession().setAttribute("user", new User(username, password)); //将登陆用户信息存入到session域对象中
            return "dfw";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "发生未知错误";
    }

*/

}

