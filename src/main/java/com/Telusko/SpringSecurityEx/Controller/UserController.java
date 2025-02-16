package com.Telusko.SpringSecurityEx.Controller;

import com.Telusko.SpringSecurityEx.Models.UsersEntity;
import com.Telusko.SpringSecurityEx.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public void register(@RequestBody UsersEntity newuser) {
        userServices.RegisterUser(newuser);
    }

    @PostMapping("/login")
    public String login(@RequestBody UsersEntity loginUser) {
        return userServices.verify(loginUser);
    }

}