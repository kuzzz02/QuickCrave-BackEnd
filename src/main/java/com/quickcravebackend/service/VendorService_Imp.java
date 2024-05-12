package com.quickcravebackend.service;

import com.quickcravebackend.mapper.VendorMapper;
import com.quickcravebackend.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService_Imp implements VendorService{
    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public Integer insert(String name, String password, String email, String phone, String address, String state, String date, String portrait, String description, String image, Long time, Long fee, String quantity){
        return vendorMapper.insert(name, password, email, phone, address, state, date, portrait, description, image, time, fee, quantity);
    }

    @Override
    public List<Vendor> selectAll() {
        return vendorMapper.selectAll();
    }
    @Override
    public Vendor selectByName(String name) {
        return vendorMapper.selectByName(name);
    }

    @Override
    public Integer delete(Long id){
        return vendorMapper.delete(id);
    }

    @Override
    public Integer update(Long id){
        return vendorMapper.update(id);
    }

    @Override
    public Vendor selectById(Long id){
        return vendorMapper.selectById(id);
    }

    @Override
    public Integer deleteAll(){
        return vendorMapper.deleteAll();
    }

    @Override
    public List<Vendor> selectVendorWithGoods(Long id){
        return vendorMapper.selectVendorWithGoods(id);
    }
}
