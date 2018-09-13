package com.zzx.filterlistenerintercept.controller;

import com.zzx.filterlistenerintercept.implement.IUserService;
import com.zzx.filterlistenerintercept.listenerfilterintercept.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/24 13:47
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    Listener listener;

    @PostMapping("/login")
    public int getOne(HttpServletRequest request, HttpServletResponse response, @RequestParam("userName")String userName, @RequestParam("password")String password){
        response.addCookie(new Cookie("Test3","dfgdfg"));
        return userService.getOne(userName,password,request,response);
    }

    @PostMapping("/logOut")
    public void logOut(HttpServletRequest request,HttpServletResponse response){
        listener.logoutSuccess(request,response);
    }



}
