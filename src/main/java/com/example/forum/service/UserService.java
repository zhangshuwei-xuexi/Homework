package com.example.forum.service;

import com.example.forum.dao.BussinessMapper;
import com.example.forum.dao.ConsumerMapper;
import com.example.forum.entity.Bussiness;
import com.example.forum.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    BussinessMapper bussinessMapper;
    @Autowired
    ConsumerMapper consumerMapper;
    public int login(String username,String password){
        //1:商家，2：消费者，3：错误
        int result1=bussinessMapper.selectByUP(username, password);
        if(result1==1){
            return 1;
        }
        int result2=consumerMapper.selectByUP(username, password);
        if(result2==1){
            return 2;
        }
        return 3;
    }

    public int busreg(Bussiness bussiness) {
        int count1=bussinessMapper.selectByName(bussiness.getUsername());
        int count2=consumerMapper.selectByName(bussiness.getUsername());
        if(count1==1||count2==1){
            return 2;
        }
        int result=bussinessMapper.insertBussiness(bussiness);
        if(result!=-1){
            return 1;
        }
        return 3;

    }

    public int conreg(Consumer consumer) {
        int count1=bussinessMapper.selectByName(consumer.getUsername());
        int count2=consumerMapper.selectByName(consumer.getUsername());
        if(count1==0&&count2==0){
            int result=consumerMapper.insertConsumer(consumer);
            if(result!=-1){
                return 1;
            }else{
                return 3;
            }
        }
        return 2;//重复
    }
}
