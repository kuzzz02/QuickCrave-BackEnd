package com.quickcravebackend.controller;

import com.quickcravebackend.model.User;
import com.quickcravebackend.service.UserService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService_Imp userService_Imp;

    @PostMapping ("insert")
    public Integer insert(String name, String password){
        return userService_Imp.insert(name,password);
    }

    @GetMapping("/selectAll")
    public List<User> selectAll() {
        return userService_Imp.selectAll();
    }
    @GetMapping("/selectByName")
    public User selectByName(String name) {
        return userService_Imp.selectByName(name);
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return userService_Imp.delete(id);
    }

    @PutMapping("/update")
    public Integer update(Long id){
        return userService_Imp.update(id);
    }

    @GetMapping("/login")
    public User Login(String name, String password) {
        if(selectByName(name) != null){
            User user = selectByName(name);
            String cur_name = user.getName();
            String cur_password = user.getPassword();
            if ((Objects.equals(cur_name, name)) && (Objects.equals(cur_password, password))) {
                return selectByName(name);
            }
        }
        return null;
    }

    @PostMapping("/signup")
    @ResponseBody
    public User Register(String name, String password) {
        if(selectByName(name) == null){
            insert(name,password);
            return selectByName(name);
        }
        return null;
    }

    @GetMapping("/user/selectById")
    public User selectById(Long id){
        return userService_Imp.selectById(id);
    }
}
