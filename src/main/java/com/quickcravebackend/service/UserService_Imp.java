package com.quickcravebackend.service;

import com.quickcravebackend.mapper.UserMapper;
import com.quickcravebackend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService_Imp implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insert(String username, String password){
        return userMapper.insert(username,password);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
    @Override
    public User selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public Integer delete(Long id){
        return userMapper.delete(id);
    }

    @Override
    public Integer update(Long id){
        return userMapper.update(id);
    }
}
