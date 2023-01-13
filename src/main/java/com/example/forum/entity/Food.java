package com.example.forum.entity;


public class Food {

  private long id;
  private long bussinessId;
  private String name;
  private String price;
  private String size;
  private String safety;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getBussinessId() {
    return bussinessId;
  }

  public void setBussinessId(long bussinessId) {
    this.bussinessId = bussinessId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }


  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }


  public String getSafety() {
    return safety;
  }

  public void setSafety(String safety) {
    this.safety = safety;
  }

}
