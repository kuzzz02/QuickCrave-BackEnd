package com.quickcravebackend.service;

import com.quickcravebackend.model.UserModel;

import java.util.List;

public interface UserLoginService {
    List<UserModel> queryAll();

    UserModel queryByName(String username);

    Integer insert(UserModel user);
}
