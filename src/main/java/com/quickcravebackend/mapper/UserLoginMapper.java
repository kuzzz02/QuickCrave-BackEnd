package com.quickcravebackend.mapper;
import com.quickcravebackend.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    List<UserModel> queryAll();

    UserModel queryByName(String username);

    int insert(UserModel user);
}
