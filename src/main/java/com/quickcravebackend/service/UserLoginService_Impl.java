package com.quickcravebackend.service;

import com.quickcravebackend.mapper.UserLoginMapper;
import com.quickcravebackend.model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserLoginService_Impl implements UserLoginService{
    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public List<UserModel> queryAll() {
        return userLoginMapper.queryAll();
    }
    @Override
    public UserModel queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }

    @Override
    public Integer insert(UserModel user){
        return userLoginMapper.insert(user);
    }
}
