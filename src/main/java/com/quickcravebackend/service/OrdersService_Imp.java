package com.quickcravebackend.service;

import com.quickcravebackend.mapper.OrdersMapper;
import com.quickcravebackend.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService_Imp implements OrdersService{
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Integer insert(String orders_id, String goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String address, String phone, String payment, String total) {
        return ordersMapper.insert(orders_id, goods_id, user_id, vendor_id, delivery_id, state, date, address, phone, payment, total);
    }

    @Override
    public Integer delete(Long id) {
        return ordersMapper.delete(id);
    }

    @Override
    public Integer deleteAll() {
        return ordersMapper.deleteAll();
    }

    @Override
    public List<Orders> selectAll() {
        return ordersMapper.selectAll();
    }

    @Override
    public Orders selectByOrdersId(String orders_id) {
        return ordersMapper.selectByOrdersId(orders_id);
    }

    @Override
    public Integer updateState(Long id, String state) {
        return ordersMapper.updateState(id, state);
    }
}
