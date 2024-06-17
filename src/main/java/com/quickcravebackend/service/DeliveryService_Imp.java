package com.quickcravebackend.service;

import com.quickcravebackend.mapper.DeliveryMapper;
import com.quickcravebackend.model.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService_Imp implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Override
    public Integer insert(String name, String password, String address, String phone) {
        return deliveryMapper.insert(name, password, address, phone);
    }

    @Override
    public List<Delivery> selectAll() {
        return deliveryMapper.selectAll();
    }

    @Override
    public Delivery selectByName(String name) {
        return deliveryMapper.selectByName(name);
    }

    @Override
    public Delivery selectById(Long id) {
        return deliveryMapper.selectById(id);
    }

    @Override
    public List<Delivery> selectByState(String state) {
        return deliveryMapper.selectByState(state);
    }

    @Override
    public Integer delete(Long id) {
        return deliveryMapper.delete(id);
    }

    @Override
    public Integer deleteAll() {
        return deliveryMapper.deleteAll();
    }

    @Override
    public Integer update(Long id, String name, String password) {
        return deliveryMapper.update(id,name,password);
    }

    @Override
    public Integer updateState(Long id, String state) {
        return deliveryMapper.updateState(id,state);
    }
}
