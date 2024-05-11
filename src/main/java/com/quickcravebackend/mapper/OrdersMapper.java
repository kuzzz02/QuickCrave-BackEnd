package com.quickcravebackend.mapper;

import com.quickcravebackend.model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrdersMapper {
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    Integer insert(Long id, Long goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String price, String total);

    Integer delete(Long id);

    Integer deleteAll();

    List<Orders> selectAll();

    Orders selectById(Long id);
}
