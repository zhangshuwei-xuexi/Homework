package com.example.forum.event;

import com.alibaba.fastjson.JSONObject;
import com.example.forum.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unchecked")
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 处理事件
    public void fireEvent(Events event) {
        // 将事件发布到指定的主题
        System.out.println("kafka发送消息");
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }

}
