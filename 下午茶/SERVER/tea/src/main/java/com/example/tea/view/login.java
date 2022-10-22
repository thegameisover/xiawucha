package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.user;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController

public class login {
    @RequestMapping(value="/login" ,method = RequestMethod.POST)
    public String LogIn(@RequestBody String data)
    {
        user User= JSON.parseObject(data,user.class);
        System.out.println(User.getAccount());
        return "1";
    }
}
