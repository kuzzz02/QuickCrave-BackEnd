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
    public Integer insert(String name, String password, String phone, String address, String portrait, String description, String image, String category){
        return vendorMapper.insert(name, password, phone, address, portrait, description, image, category);
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
    public List<Vendor> selectByCategory(String category){
        return vendorMapper.selectByCategory(category);
    }

    @Override
    public List<Vendor> selectVendorWithGoods(Long id){
        return vendorMapper.selectVendorWithGoods(id);
    }

    @Override
    public Integer delete(Long id){
        return vendorMapper.delete(id);
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
    public Integer updateName(Long id, String name){
        return vendorMapper.updateName(id, name);
    }

    @Override
    public Integer updatePassword(Long id, String password){
        return vendorMapper.updatePassword(id, password);
    }

    @Override
    public Integer updateEmail(Long id, String email){
        return vendorMapper.updateEmail(id, email);
    }

    @Override
    public Integer updatePhone(Long id, String phone){
        return vendorMapper.updatePhone(id, phone);
    }

    @Override
    public Integer updateAddress(Long id, String address){
        return vendorMapper.updateAddress(id, address);
    }

    @Override
    public Integer updateState(Long id, String state){
        return vendorMapper.updateState(id, state);
    }

    @Override
    public Integer updateDate(Long id, String date){
        return vendorMapper.updateDate(id, date);
    }

    @Override
    public Integer updatePortrait(Long id, String portrait){
        return vendorMapper.updatePortrait(id, portrait);
    }

    @Override
    public Integer updateDescription(Long id, String description){
        return vendorMapper.updateDescription(id, description);
    }

    @Override
    public Integer updateImage(Long id, String image){
        return vendorMapper.updateImage(id, image);
    }

    @Override
    public Integer updateCategory(Long id, String category){
        return vendorMapper.updateCategory(id, category);
    }

    @Override
    public Integer updateTime(Long id, Long time){
        return vendorMapper.updateTime(id, time);
    }

    @Override
    public Integer updateFee(Long id, Long fee){
        return vendorMapper.updateFee(id, fee);
    }

    @Override
    public Integer updateQuantity(Long id, String quantity){
        return vendorMapper.updateQuantity(id, quantity);
    }
}
