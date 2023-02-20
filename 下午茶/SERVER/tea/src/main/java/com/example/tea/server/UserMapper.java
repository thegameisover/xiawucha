package com.example.tea.server;

import com.example.tea.dao.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserMapper implements User {
    @Autowired
   private User user;
    @Override
    public String getName(String account, String password) {
        return user.getName(account,password);
    }

    @Override
    public void SetUser(int id, String Username, String account, String password) {
        user.SetUser(id,Username,account,password);
    }

    @Override
    public int GetId() {
        return user.GetId();
    }

    @Override
    public int getid(String account) {
        return user.getid(account);
    }

    @Override
    public void setid(int id) {
        user.setid(id);
    }

    @Override
    public int IdName(String name) {
        return user.IdName(name);
    }

    @Override
    public Map<String, Object> getUser(String account, String password) {
        return user.getUser(account,password);
    }

    @Override
    public void modifyUser(String account, String password,String name) {
        user.modifyUser(account,password,name);
    }
}
