package com.example.forum.dao;

import com.example.forum.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ConsumerMapper {
    int selectByUP(@Param("username") String username, @Param("password") String password);
    int selectByName(String username);
    int insertConsumer(Consumer consumer);
    Consumer selectByFalseName(String username);
}
