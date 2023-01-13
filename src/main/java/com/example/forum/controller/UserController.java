package com.example.forum.controller;


import com.example.forum.entity.Bussiness;
import com.example.forum.entity.Consumer;
import com.example.forum.entity.HttpResponseEntity;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public HttpResponseEntity login(@RequestBody Map<String,Object> map, HttpServletRequest request){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();
        String username= (String) map.get("username");
        String password= (String) map.get("password");
//        HttpSession session = request.getSession();
//        session.setAttribute("username",username);
        System.out.println(username+" "+password);
        int result=userService.login(username,password);
        httpResponseEntity.setCode(""+result);
        httpResponseEntity.setData(username);
        return httpResponseEntity;
    }
    @RequestMapping("/busreg")
    public HttpResponseEntity busreg(@RequestBody Bussiness bussiness){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();
        int result=userService.busreg(bussiness);
        httpResponseEntity.setCode(""+result);
        return httpResponseEntity;
    }
    @RequestMapping("/conreg")
    public HttpResponseEntity conreg(@RequestBody Consumer consumer){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();
        int result=userService.conreg(consumer);
        httpResponseEntity.setCode(""+result);
        return httpResponseEntity;
    }

}
