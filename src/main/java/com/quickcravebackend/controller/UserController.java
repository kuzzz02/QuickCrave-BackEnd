package com.quickcravebackend.controller;

import com.quickcravebackend.Utility.Response;
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

    @PostMapping ("/insert")
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
    public Integer update(Long id, String name, String password){
        return userService_Imp.update(id, name, password);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> Login(@RequestBody User user) {
        User newUser = selectByName(user.getName());
        if(newUser != null && Objects.equals(newUser.getPassword(), user.getPassword())){
            return ResponseEntity.ok(new Response("success login"));
        }
        else {
            return ResponseEntity.ok(new Response("fail to login"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> Register(@RequestBody User user) {
        if(user.getName() != null && user.getPassword() != null && selectByName(user.getName()) == null){
            insert(user.getName(),user.getPassword());
            return ResponseEntity.ok(new Response("success register"));
        }
        else {
            return ResponseEntity.ok(new Response("fail to register"));
        }
    }

}
