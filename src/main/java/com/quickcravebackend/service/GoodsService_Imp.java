package com.quickcravebackend.service;

import com.quickcravebackend.mapper.GoodsMapper;
import com.quickcravebackend.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService_Imp implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer insert(String name, String description, String image, String state, String date, String price, String quantity, String discount, Long vendor_id) {
        return goodsMapper.insert(name, description, image, state, date, price, quantity, discount, vendor_id);
    }

    @Override
    public Integer delete(Long id) {
        return goodsMapper.delete(id);
    }

    @Override
    public Integer deleteAll() {
        return goodsMapper.deleteAll();
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public Goods selectById(Long id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public Goods selectByName(String name) {
        return goodsMapper.selectByName(name);
    }

    @Override
    public Integer update(Long id) {
        return goodsMapper.update(id);
    }

    @Override
    public Integer updateName(Long id, String name) {
        return goodsMapper.updateName(id, name);
    }

    @Override
    public Integer updateDescription(Long id, String description) {
        return goodsMapper.updateDescription(id, description);
    }

    @Override
    public Integer updateImage(Long id, String image) {
        return goodsMapper.updateImage(id, image);
    }

    @Override
    public Integer updateState(Long id, String state) {
        return goodsMapper.updateState(id, state);
    }

    @Override
    public Integer updateDate(Long id, String date) {
        return goodsMapper.updateDate(id, date);
    }

    @Override
    public Integer updatePrice(Long id, String price) {
        return goodsMapper.updatePrice(id, price);
    }

    @Override
    public Integer updateDiscount(Long id, String discount) {
        return goodsMapper.updateDiscount(id, discount);
    }

    @Override
    public Integer updateQuantity(Long id, String quantity) {
        return goodsMapper.updateQuantity(id, quantity);
    }

    @Override
    public Integer updateVendor(Long id, Long vendor_id) {
        return goodsMapper.updateVendor(id, vendor_id);
    }
}
