package com.quickcravebackend.controller;

import com.quickcravebackend.model.User;
import com.quickcravebackend.service.UserService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    private UserService_Imp userService_Imp;

    @PostMapping ("/user/insert")
    public Integer insert(String name, String password){
        return userService_Imp.insert(name,password);
    }

    @GetMapping("/user/selectAll")
    public List<User> selectAll() {
        return userService_Imp.selectAll();
    }
    @GetMapping("/user/selectByName")
    public User selectByName(String name) {
        return userService_Imp.selectByName(name);
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
    public String Login(String name, String password) {
        if(selectByName(name) != null){
            User user = selectByName(name);
            String cur_name = user.getName();
            String cur_password = user.getPassword();
            if ((Objects.equals(cur_name, name)) && (Objects.equals(cur_password, password))) {
                return "success";
            }
        }
        return "fail";
    }

    @PostMapping("/user/signup")
    public String Register(String name, String password) {
        if(selectByName(name) == null){
            insert(name,password);
            return "success";
        }
        return "fail";
    }

    @GetMapping("/user/selectById")
    public User selectById(Long id){
        return userService_Imp.selectById(id);
    }
}
