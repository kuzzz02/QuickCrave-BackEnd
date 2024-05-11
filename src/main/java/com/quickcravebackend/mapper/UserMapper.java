package com.quickcravebackend.mapper;

import com.quickcravebackend.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Options(useGeneratedKeys = true,keyProperty="id",keyColumn="id")
    Integer insert(String name, String password);
    List<User> selectAll();

    User selectByName(String name);

    Integer delete(Long id);

    Integer update(Long id);

    User selectById(Long id);

    Integer deleteAll();
}
