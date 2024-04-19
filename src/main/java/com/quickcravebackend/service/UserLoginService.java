package com.quickcravebackend.service;

import com.quickcravebackend.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserLoginService {
    List<UserModel> queryAll();

    UserModel queryByName(String username);

    Integer insert(UserModel user);
}
