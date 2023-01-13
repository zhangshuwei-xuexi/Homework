package com.example.forum.dao;

import com.example.forum.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodMapper {
    List<Food> targetFood( @Param("low") int low, @Param("high") int high);

    List<Food> getFoodByName(@Param("bussinessId") int id,@Param("name") String name);

    void addFood(Food food);

    void deleteFood(int id);

    void modifyFood(Food food);

    List<Food> getAllFood();

    int getMaxId();
}
