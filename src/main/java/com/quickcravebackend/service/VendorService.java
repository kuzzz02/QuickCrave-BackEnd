package com.quickcravebackend.service;

import com.quickcravebackend.model.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {
    Integer insert(String name, String password);
    List<Vendor> selectAll();

    Vendor selectByName(String name);

    Integer delete(Long id);

    Integer update(Long id);

    Vendor selectById(Long id);

    Integer deleteAll();

    List<Vendor> selectVendorWithGoods(Long id);
}
