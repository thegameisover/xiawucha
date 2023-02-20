package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.user;
import com.example.tea.dao.User;
import com.example.tea.server.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logup {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/logup",method = RequestMethod.POST)
    public String Logup(@RequestBody String data)
    {
       user User = JSON.parseObject(data,user.class);
       try{
           int id = userMapper.getid(User.getAccount());
           return "exist";
       }catch (Exception e)
       {
           int num =userMapper.GetId();
           userMapper.SetUser(num+1,User.getUsername(),User.getAccount(),User.getPassword());
           String name = userMapper.getName(User.getAccount(),User.getPassword());
           if(name==null)
           {
               return "failure";
           }
           else
           {
               userMapper.setid(num+1);
               return "successful";
           }
       }
    }
}
