package com.quickcravebackend.mapper;

import com.quickcravebackend.model.Vendor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VendorMapper {
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    Integer insert (String name, String password, String email, String phone, String address, String state, String date, String portrait, String description, String image, Long time, Long fee, String quantity);

    List<Vendor> selectAll();

    Vendor selectByName(String name);

    Integer delete(Long id);

    Integer update(Long id);

    Vendor selectById(Long id);

    Integer deleteAll();

    List<Vendor> selectVendorWithGoods(Long id);
}
