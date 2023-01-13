package com.example.forum.entity;

public class Orders {

  private String consumerName;
  private String consumerPhone;
  private String consumerPosition;
  private long bussinessId;
  private String bussinessFoodname;
  private long id;
  private String time;


  public String getConsumerName() {
    return consumerName;
  }

  public void setConsumerName(String consumerName) {
    this.consumerName = consumerName;
  }


  public String getConsumerPhone() {
    return consumerPhone;
  }

  public void setConsumerPhone(String consumerPhone) {
    this.consumerPhone = consumerPhone;
  }


  public String getConsumerPosition() {
    return consumerPosition;
  }

  public void setConsumerPosition(String consumerPosition) {
    this.consumerPosition = consumerPosition;
  }


  public long getBussinessId() {
    return bussinessId;
  }

  public void setBussinessId(long bussinessId) {
    this.bussinessId = bussinessId;
  }


  public String getBussinessFoodname() {
    return bussinessFoodname;
  }

  public void setBussinessFoodname(String bussinessFoodname) {
    this.bussinessFoodname = bussinessFoodname;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

}
