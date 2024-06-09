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
    Integer insert(String orders_id, String goods_id, Long user_id, Long vendor_id, Long delivery_id, String state, String date, String address, String phone, String payment, String total);

    Integer delete(Long id);

    Integer deleteAll();

    List<Orders> selectAll();

    Orders selectByOrdersId(String orders_id);

    Integer updateState(Long id, String state);
}
