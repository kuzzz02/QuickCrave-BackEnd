package com.quickcravebackend.service;

import com.quickcravebackend.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {
    Integer insert(String orders_id, String goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String address, String phone, String payment, String total);

    List<Orders> selectAll();

    Orders selectByOrdersId(String orders_id);

    Integer delete(Long id);

    Integer deleteAll();

    Integer updateState(String orders_id, String state);
}
