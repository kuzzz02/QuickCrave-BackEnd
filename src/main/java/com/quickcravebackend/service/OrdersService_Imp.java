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
    public Integer insert(Long id, Long goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String price, String total) {
        return ordersMapper.insert(id, goods_id, user_id, vendor_id, delivery_id, state, date, price, total);
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
    public Orders selectById(Long id) {
        return ordersMapper.selectById(id);
    }
}
