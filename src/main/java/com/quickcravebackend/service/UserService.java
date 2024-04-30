package com.quickcravebackend.service;

import com.quickcravebackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Integer insert(String username, String password);
    List<User> selectAll();

    User selectByName(String username);

    Integer delete(Long id);

    Integer update(Long id);
}
