package com.example.forum.entity;

import java.util.HashMap;
import java.util.Map;

public class Events {
    private String topic;
    private Map<String, Object> data = new HashMap<>();

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
