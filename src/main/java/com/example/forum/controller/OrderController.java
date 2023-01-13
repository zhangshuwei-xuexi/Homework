package com.example.forum.controller;


import com.example.forum.entity.Events;
import com.example.forum.entity.HttpResponseEntity;
import com.example.forum.entity.Orders;
import com.example.forum.event.EventProducer;
import com.example.forum.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    EventProducer eventProducer;
    @RequestMapping("/myorder")
    public HttpResponseEntity getMyOrder(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        String bussinessId1= (String) map.get("bussinessId");
        System.out.println(bussinessId1);
        int bussinessId=Integer.parseInt(bussinessId1);
        List<Orders> list=orderService.getOrdersByBussId(bussinessId);
        httpResponseEntity.setData(list);
        return httpResponseEntity;
    }
    @RequestMapping("/myorders")
    public HttpResponseEntity getMyOrders(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
//        String consumerUserName= (String) request.getSession().getAttribute("username");
        String consumerUserName= (String) map.get("username");
        List<Orders> list=orderService.getMyOrdersByUserName(consumerUserName);
        httpResponseEntity.setData(list);
        return httpResponseEntity;
    }
    @RequestMapping("/delete")
    public HttpResponseEntity deleteOrder(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        int id= (int) map.get("id");
        orderService.deleteOrder(id);
        return httpResponseEntity;
    }
    @RequestMapping("/add")
    public HttpResponseEntity addOrder(@RequestBody Map<String,Object> map, HttpServletRequest request){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
//        String consumerName= (String) request.getSession().getAttribute("username");
        String consumerName= (String) map.get("username");
        int bussinessId= (int) map.get("bussinessId");
        String bussinessFoodname= (String) map.get("bussinessFoodname");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        Events event=new Events();
        event.setTopic("ORDER");
        Map<String,Object> mapp=event.getData();
        mapp.put("consumerUsername",consumerName);
        mapp.put("bussinessId",bussinessId);
        mapp.put("bussinessFoodName",bussinessFoodname);
        mapp.put("time",time);
        eventProducer.fireEvent(event);

//        Orders orders=new Orders();
//        orders.setConsumerName(consumerName);
//        orders.setBussinessId(bussinessId);
//        orders.setBussinessFoodname(bussinessFoodname);
//        orders.setTime(time);
//        orderService.addOrder(orders);
        return httpResponseEntity;
    }
}
