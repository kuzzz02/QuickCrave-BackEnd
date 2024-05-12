package com.quickcravebackend.mapper;

import com.quickcravebackend.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    Integer insert(String name, String description, String image, String state, String date, String price, String quantity, String discount, Long vendor_id);

    Integer delete(Long id);

    Integer deleteAll();

    List<Goods> selectAll();

    Goods selectById(Long id);

    Goods selectByName(String name);

    Integer update(Long id);

    Integer updateName(Long id, String name);

    Integer updateDescription(Long id, String description);

    Integer updateImage(Long id, String image);

    Integer updateState(Long id, String state);

    Integer updateDate(Long id, String date);

    Integer updatePrice(Long id, String price);

    Integer updateDiscount(Long id, String discount);

    Integer updateQuantity(Long id, String quantity);

    Integer updateVendor(Long id, Long vendor_id);
}
