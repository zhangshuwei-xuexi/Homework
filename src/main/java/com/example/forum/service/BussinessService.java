package com.example.forum.service;

import com.example.forum.dao.BussinessMapper;
import com.example.forum.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinessService {
    @Autowired
    BussinessMapper bussinessMapper;
    public List<Food> getMyFood(String username) {
        int id=bussinessMapper.getIdByUserName(username);
        System.out.println("id="+id);
        List<Food> list=bussinessMapper.getMyFood(id);
        System.out.println("list.size="+list.size());
        return list;
    }
}
