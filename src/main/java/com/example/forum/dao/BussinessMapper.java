package com.example.forum.dao;

import com.example.forum.entity.Bussiness;
import com.example.forum.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BussinessMapper {
    int selectByUP(@Param("username") String username, @Param("password") String password);
    int selectByName(String username);
    int insertBussiness(Bussiness bussiness);
    int getIdByUserName(String username);
    List<Food> getMyFood(int id);
    int getIdByCanName(String name);

}
