package com.quickcravebackend.service;

import com.quickcravebackend.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {
    Integer insert (String name, String password, String phone, String address, String portrait, String description, String image, String category);
    List<Vendor> selectAll();

    Vendor selectByName(String name);

    Vendor selectById(Long id);

    List<Vendor> selectByCategory(String category);

    List<Vendor> selectVendorWithGoods(Long id);

    Integer delete(Long id);

    Integer deleteAll();

    Integer updateName(Long id, String name);

    Integer updatePassword(Long id, String password);

    Integer updateEmail(Long id, String email);

    Integer updatePhone(Long id, String phone);

    Integer updateAddress(Long id, String address);

    Integer updateState(Long id, String state);

    Integer updateDate(Long id, String date);

    Integer updatePortrait(Long id, String portrait);

    Integer updateDescription(Long id, String description);

    Integer updateImage(Long id, String image);

    Integer updateCategory(Long id, String category);

    Integer updateTime(Long id, Long time);

    Integer updateFee(Long id, Long fee);

    Integer updateQuantity(Long id, String quantity);

}
