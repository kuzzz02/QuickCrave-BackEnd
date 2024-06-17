package com.quickcravebackend.service;

import com.quickcravebackend.model.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    Integer insert(String name, String description, String image, String number, String price, String discount, Long vendor_id);

    List<Goods> selectAll();

    Goods selectByName(String name);

    Goods selectById(Long id);

    Integer delete(Long id);

    Integer deleteAll();

    Integer updateName(Long id, String name);

    Integer updateDescription(Long id, String description);

    Integer updateImage(Long id, String image);

    Integer updateNumber(Long id, String number);

    Integer updatePrice(Long id, String price);

    Integer updateDiscount(Long id, String discount);

    Integer updateVendor(Long id, Long vendor_id);
}
