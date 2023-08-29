 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.test.bean;

 import java.util.HashMap;
 import java.util.Map;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 13:35
  */
 public class UserDao {
   private static Map<String, String> hashMap = new HashMap<>();

   static {
     hashMap.put("10001", "test1001");
   }

   public String queryUserName(String uId) {
     return hashMap.get(uId);
   }
 }
