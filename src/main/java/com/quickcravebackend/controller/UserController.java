package com.quickcravebackend.controller;

import com.quickcravebackend.model.User;
import com.quickcravebackend.service.UserService_Imp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/selectById")
    public User selectById(Long id){
        return userService_Imp.selectById(id);
    }

    @DeleteMapping("/delete")
    public Integer delete(Long id){
        return userService_Imp.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public Integer deleteAll(){
        return userService_Imp.deleteAll();
    }

    @PutMapping("/update")
    public Integer update(Long id){
        return userService_Imp.update(id);
    }

    @PostMapping("/login")
    public ResponseEntity<User> Login(@RequestBody User user) {
        User newUser = selectByName(user.getName());
        if(newUser != null && Objects.equals(newUser.getPassword(), user.getPassword())){
            return ResponseEntity.ok(newUser);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> Register(@RequestBody User user) {
        if(user.getName() != null && user.getPassword() != null && selectByName(user.getName()) == null){
            insert(user.getName(),user.getPassword());
            User newUser = selectByName(user.getName());
            return ResponseEntity.ok(newUser);
        }
        return ResponseEntity.badRequest().build();
    }

}
