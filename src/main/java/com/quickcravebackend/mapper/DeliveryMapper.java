package com.quickcravebackend.mapper;

import com.quickcravebackend.model.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeliveryMapper {
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    Integer insert (String name, String password, String address, String phone);

    List<Delivery> selectAll();

    Delivery selectByName(String name);

    Delivery selectById(Long id);

    List<Delivery> selectByState(String state);

    Integer delete(Long id);

    Integer deleteAll();

    Integer update(Long id, String name, String password);

    Integer updateState(Long id, String state);
}
