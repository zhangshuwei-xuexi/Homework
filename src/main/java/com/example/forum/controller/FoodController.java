package com.example.forum.controller;

import com.example.forum.entity.Food;
import com.example.forum.entity.HttpResponseEntity;
import com.example.forum.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping("/target")
    public HttpResponseEntity findFood(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        String  price= (String) map.get("find");
        String[] prices = price.split("-");
        if(prices.length!=2){
            httpResponseEntity.setCode(""+2);
            return httpResponseEntity;
        }
        int low = Integer.parseInt(prices[0]);
        int high = Integer.parseInt(prices[1]);
        List<Food> list=foodService.getTargetFood(low,high);
        httpResponseEntity.setData(list);
        httpResponseEntity.setCode(""+1);
        return httpResponseEntity;
    }
    @RequestMapping("/target1")
    public HttpResponseEntity findFoodByName(@RequestBody Map<String,Object> map, HttpServletRequest request){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        String username= (String) map.get("username");
//        String username= (String) request.getSession().getAttribute("username");
        String name=(String)map.get("find");
        List<Food> list=foodService.getFoodByName(username,name);
        httpResponseEntity.setData(list);
        return httpResponseEntity;
    }
    @RequestMapping("/delete")
    public HttpResponseEntity deleteFoodById(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        int id= (int) map.get("id");
        foodService.deleteFoodById(id);
        return httpResponseEntity;
    }
    @RequestMapping("/modify")
    public HttpResponseEntity modifyFoodById(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        String id1= (String) map.get("id");
        int id=Integer.parseInt(id1);
        String name= (String) map.get("name");
        String price= (String) map.get("price");
        String size= (String) map.get("size");
        if(name==null||price==null||size==null){
            httpResponseEntity.setData(""+2);
            return httpResponseEntity;
        }
        Food food=new Food();
        food.setId(id);
        food.setName(name);
        food.setPrice(price);
        food.setSize(size);
        foodService.modifyFood(food);
        httpResponseEntity.setData(""+1);
        return httpResponseEntity;
    }
    @RequestMapping("/add")
    public HttpResponseEntity addFood(@RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        Food food=new Food();
        String name= (String) map.get("name");
        String price= (String) map.get("price");
        String size= (String) map.get("size");
        String can=(String)map.get("can");
        if(name==null||price==null||size==null||can==null){
            httpResponseEntity.setData(""+2);
            return httpResponseEntity;
        }
        food.setName(name);
        food.setPrice(price);
        food.setSize(size);
        foodService.addFood(food,can);
        httpResponseEntity.setData(""+1);
        return httpResponseEntity;

    }
    @RequestMapping("/all")
    public HttpResponseEntity allFood(){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        List<Food> list=foodService.getAllFood();
        httpResponseEntity.setData(list);
        return httpResponseEntity;

    }
}
