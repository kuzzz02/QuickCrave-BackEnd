package com.quickcravebackend.service;

import com.quickcravebackend.model.Delivery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeliveryService {
    Integer insert(String name, String password);
    List<Delivery> selectAll();

    Delivery selectByName(String name);

    Integer delete(Long id);

    Integer update(Long id, String name, String password);

    Delivery selectById(Long id);

    Integer deleteAll();
}
