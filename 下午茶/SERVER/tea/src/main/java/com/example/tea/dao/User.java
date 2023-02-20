package com.example.tea.dao;


import java.util.Map;

public interface User {
   public String getName(String account,String password);
/*注册用户*/
   public void SetUser(int id,String Username,String account,String password);
   /*获取最后一个数据的id*/
   public int GetId();
   /*判断用户是否存在*/
   public int getid(String account);

   /*修改控制注册的值*/
   public void setid(int id);

/*根据用户名查询id*/
   public int IdName(String name);

   /*获取用户名，账号，密码*/
   public Map getUser(String account,String password);

   /*修改用户名，账号和密码*/
   public void modifyUser(String account,String password,String name);

}
