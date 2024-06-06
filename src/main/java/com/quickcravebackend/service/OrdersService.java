package com.quickcravebackend.service;

import com.quickcravebackend.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {
    Integer insert(Long id, Long goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String address, String phone, String payment, String total);

    Integer delete(Long id);

    Integer deleteAll();

    List<Orders> selectAll();

    Orders selectById(Long id);
}
