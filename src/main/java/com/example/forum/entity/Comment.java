package com.example.forum.entity;

public class Comment {

  private long id;
  private String consumerNickname;
  private String comments;
  private String time;
  private long foodId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getConsumerNickname() {
    return consumerNickname;
  }

  public void setConsumerNickname(String consumerNickname) {
    this.consumerNickname = consumerNickname;
  }


  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public long getFoodId() {
    return foodId;
  }

  public void setFoodId(long foodId) {
    this.foodId = foodId;
  }

}
