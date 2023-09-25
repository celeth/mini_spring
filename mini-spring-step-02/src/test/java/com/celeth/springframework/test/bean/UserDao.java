package com.celeth.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

  private String name;

  private static Map<String, String> hashMap = new HashMap<>();

  static {
    hashMap.put("10001", "test1");
    hashMap.put("10002", "test2");
    hashMap.put("10003", "test2");
  }

  public UserDao(String name) {
    this.name = name;
  }

  public UserDao() {
    this.name = "name";
  }

  public String queryUserName(String uId) {
    return hashMap.get(uId);
  }

  public void print() {
    System.out.println(this.name);
  }
}
