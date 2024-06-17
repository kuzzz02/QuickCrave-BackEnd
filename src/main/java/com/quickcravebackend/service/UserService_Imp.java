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
    public Integer insert(String name, String password, String address, String phone){
        return userMapper.insert(name,password,address,phone);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public User selectById(Long id){
        return userMapper.selectById(id);
    }

    @Override
    public Integer delete(Long id){
        return userMapper.delete(id);
    }

    @Override
    public Integer deleteAll(){
        return userMapper.deleteAll();
    }

    @Override
    public Integer update(Long id, String name, String password){
        return userMapper.update(id, name, password);
    }
}
