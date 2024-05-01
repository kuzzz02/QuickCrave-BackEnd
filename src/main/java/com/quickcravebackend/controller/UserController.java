package com.quickcravebackend.controller;

import com.quickcravebackend.model.User;
import com.quickcravebackend.service.UserService_Imp;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService_Imp userService_Imp;

    @PostMapping ("/user/insert")
    public Integer insert(String username, String password){
        return userService_Imp.insert(username,password);
    }

    @GetMapping("/user/selectAll")
    public List<User> selectAll() {
        return userService_Imp.selectAll();
    }
    @GetMapping("/user/selectByName")
    public User selectByName(String username) {
        return userService_Imp.selectByName(username);
    }

    @DeleteMapping("/user/delete")
    public Integer delete(Long id){
        return userService_Imp.delete(id);
    }

    @PutMapping("/user/update")
    public Integer update(Long id){
        return userService_Imp.update(id);
    }

    @GetMapping("/user/login")
    public String Login(String username, String password) {
        if(selectByName(username) != null){
            User user = selectByName(username);
            String cur_name = user.getUsername();
            String cur_password = user.getPassword();
            if ((Objects.equals(cur_name, username)) && (Objects.equals(cur_password, password))) {
                return "success";
            }
        }
        return "fail";
    }

    @PostMapping("/user/signup")
    public String Register(String username, String password) {
        if(selectByName(username) == null){
            insert(username,password);
            return "success";
        }
        return "fail";
    }
}
