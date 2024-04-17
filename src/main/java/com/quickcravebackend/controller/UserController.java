package com.quickcravebackend.controller;

import com.quickcravebackend.model.UserModel;
import com.quickcravebackend.service.UserLoginService_Impl;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserLoginService_Impl userLoginService_Impl;

    @RequestMapping("/Login")
    public String Login(){
        return "login"; //TODO
    }

    @RequestMapping("/SignUp")
    public String Register() {
        return "signup"; //TODO
    }

    @RequestMapping("/LoginSuccess")
    public String LoginSuccess(Model model, UserModel UserModel){
        UserModel user = userLoginService_Impl.queryByName(UserModel.getUsername());
        if(user != null){
            System.out.println(user.toString());
            return "success";
        }
        else{
            model.addAttribute("data","Please Sign Up");
            return "signup";
        }
    }

    @RequestMapping("/SignUpSuccess")
    public String SignUpSuccess(Model model, UserModel UserModel){
        int insert = userLoginService_Impl.insert(UserModel);
        System.out.println("Sign Up succeed!");
        model.addAttribute("data","Log in");
        return "login";
    }
}
