package com.example.forum.service;

import com.example.forum.dao.BussinessMapper;
import com.example.forum.dao.FoodMapper;
import com.example.forum.entity.Bussiness;
import com.example.forum.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    BussinessMapper bussinessMapper;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    public List<Food> getTargetFood(int low, int high) {
        List<Food> list=foodMapper.targetFood(low,high);
        return list;
    }

    public List<Food> getFoodByName(String username,String name) {
        int id=bussinessMapper.getIdByUserName(username);
        List<Food> list=foodMapper.getFoodByName(id,name);
        return list;
    }

    public void addFood(Food food, String can) {
        int id=bussinessMapper.getIdByCanName(can);
        food.setBussinessId(id);
        foodMapper.addFood(food);
        redisTemplate.delete("food");
    }

    public void deleteFoodById(int id) {
        foodMapper.deleteFood(id);
        redisTemplate.delete("food");
    }

    public void modifyFood(Food food) {
        //旁路缓存策略，删除
        foodMapper.modifyFood(food);
        redisTemplate.delete("food");
    }

    public List<Food> getAllFood() {
        String key="food";
        if(redisTemplate.opsForList().size(key)==0){
            System.out.println(redisTemplate.opsForList().size(key));
            List<Food> list=foodMapper.getAllFood();
            for(Food food:list){
                redisTemplate.opsForList().rightPush(key,food);
            }
            return list;
        }
        List<Object> list= redisTemplate.opsForList().range(key,0,-1);
        List<Food> food=new ArrayList<>();
        for(Object object:list){
            food.add((Food) object);
        }
        return food;
    }
}
