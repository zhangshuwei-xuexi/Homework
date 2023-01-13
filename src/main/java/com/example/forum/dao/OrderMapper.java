package com.example.forum.dao;

import com.example.forum.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Orders> selectOrderByBussId(int bussinessId);

    void deleteOrder(int id);

    void addOrder(Orders orders);

    List<Orders> selectOrderByConName(String consumerName);
}
