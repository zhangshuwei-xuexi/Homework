package com.example.forum.event;

import com.alibaba.fastjson.JSONObject;
import com.example.forum.entity.Events;
import com.example.forum.entity.Orders;
import com.example.forum.service.OrderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {
    @Autowired
    OrderService orderService;
    @KafkaListener(topics = {"ORDER"})
    public void handlePublishMessage(ConsumerRecord record) {
        if (record == null || record.value() == null) {
            System.out.println("消息内容为空");
            return;
        }
        Events event = JSONObject.parseObject(record.value().toString(), Events.class);
        if (event == null) {
            System.out.println("消息格式错误");
            return;
        }
        Orders orders=new Orders();
        orders.setTime((String) event.getData().get("time"));
        orders.setConsumerName((String) event.getData().get("consumerUsername"));
        int tem= (int) event.getData().get("bussinessId");
        orders.setBussinessId(tem);
        orders.setBussinessFoodname((String) event.getData().get("bussinessFoodName"));
        orderService.addOrder(orders);
    }
}
