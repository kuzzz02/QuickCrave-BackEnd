package com.quickcravebackend.service;

import com.quickcravebackend.model.Delivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryService {
    Integer insert(String name, String password, String address, String phone);
    List<Delivery> selectAll();

    Delivery selectByName(String name);

    Delivery selectById(Long id);

    List<Delivery> selectByState(String state);

    Integer delete(Long id);

    Integer deleteAll();

    Integer update(Long id, String name, String password);

    Integer updateState(Long id, String state);
}
