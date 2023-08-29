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

   private String uId;

   private UserDao userDao;

   public void queryUserInfo() {
     System.out.println(uId);
     System.out.println("search userinfo: " + userDao.queryUserName(uId));
   }

   public String getuId() {
     return uId;
   }

   public void setuId(String uId) {
     this.uId = uId;
   }

   public UserDao getUserDao() {
     return userDao;
   }

   public void setUserDao(UserDao userDao) {
     this.userDao = userDao;
   }
 }
