package com.example.forum.service;

import com.example.forum.dao.ConsumerMapper;
import com.example.forum.dao.OrderMapper;
import com.example.forum.entity.Consumer;
import com.example.forum.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ConsumerMapper consumerMapper;
    public List<Orders> getOrdersByBussId(int bussinessId) {
        return orderMapper.selectOrderByBussId(bussinessId);
    }

    public void deleteOrder(int id) {
        orderMapper.deleteOrder(id);
    }

    public void addOrder(Orders orders) {
        Consumer consumer=consumerMapper.selectByFalseName(orders.getConsumerName());
        orders.setConsumerName(consumer.getName());
        orders.setConsumerPhone(consumer.getPhone());
        orders.setConsumerPosition(consumer.getPosition());
        orderMapper.addOrder(orders);
    }

    public List<Orders> getMyOrdersByUserName(String consumerUserName) {
        Consumer consumer=consumerMapper.selectByFalseName(consumerUserName);
        String name=consumer.getName();
        return orderMapper.selectOrderByConName(name);
    }
}
