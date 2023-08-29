 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.test.bean;

 import java.awt.print.PrinterAbortException;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 10:09
  */
 public class UserService {

   private String name;

   public UserService(String name) {
     this.name = name;
   }

   public void queryUserInfo() {
     System.out.println("查询用户信息");
   }
 }