package com.example.forum.controller;

import com.example.forum.entity.Comment;
import com.example.forum.entity.HttpResponseEntity;
import com.example.forum.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping("/add")
    public HttpResponseEntity addComment(@RequestBody Map<String,Object> map){
        Comment comment=new Comment();
        String consumerNickname= (String) map.get("username");
        int foodId= (int) map.get("foodId");
        String comments= (String) map.get("comments");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        comment.setComments(comments);
        comment.setConsumerNickname(consumerNickname);
        comment.setFoodId(foodId);
        comment.setTime(time);
        commentService.addComment(comment);
        return new HttpResponseEntity();
    }
    @RequestMapping("/get")
    public HttpResponseEntity getComment( @RequestBody Map<String,Object> map){
        HttpResponseEntity httpResponseEntity=new HttpResponseEntity();
        String foodId1= (String) map.get("foodId");
        int foodId=Integer.parseInt(foodId1);
        List<Comment> list=commentService.getComment(foodId);
        httpResponseEntity.setData(list);
        return httpResponseEntity;
    }
}
