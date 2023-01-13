package com.example.forum.controller;

import com.example.forum.entity.Food;
import com.example.forum.entity.HttpResponseEntity;
import com.example.forum.service.BussinessService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bussiness")
public class BussinessController {
    @Autowired
    BussinessService bussinessService;
    @RequestMapping("/food")
    public String getMyFood(@RequestBody Map<String,Object> map){
//        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
//        String username= (String) request.getSession().getAttribute("username");
        String username= (String) map.get("username");
        System.out.println("username="+username);
        List<Food> list=bussinessService.getMyFood(username);
        Gson gson=new Gson();
        String json = gson.toJson(list);
//        httpResponseEntity.setData(list);
        return json;
    }
}
