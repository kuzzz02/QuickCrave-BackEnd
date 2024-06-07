package com.quickcravebackend.service;

import com.quickcravebackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Integer insert(String name, String password, String address, String phone);
    List<User> selectAll();

    User selectByName(String name);

    Integer delete(Long id);

    Integer update(Long id, String name, String password);

    User selectById(Long id);

    Integer deleteAll();
}
