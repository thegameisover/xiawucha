package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.user;
import com.example.tea.dao.User;
import com.example.tea.server.Code;
import com.example.tea.server.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/login")
public class login {
    @Autowired
    private  StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;
   @PostMapping
    public String LogIn(@RequestBody String data,HttpServletResponse response)
    {
        user User= JSON.parseObject(data,user.class);
        String name= userMapper.getName(User.getAccount(),User.getPassword());
        if(name==null)
        {
            return "null";
        }
        else
        {
            ValueOperations<String,String> valueOperations=stringRedisTemplate.opsForValue();
            String key=valueOperations.get(User.getAccount());
            if(key==null)
            {
                return "code";
            }
            else
            {
                Cookie cookie1 =new Cookie("account", User.getAccount());
                Cookie cookie2 = new Cookie("password",User.getPassword());
                cookie1.setMaxAge(24*30*30*60);
                cookie1.setPath("/");
                cookie2.setMaxAge(24*30*30*60);
                cookie2.setPath("/");
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                return userMapper.getName(User.getAccount(),User.getPassword());
            }


        }

    }

    @GetMapping
    public String Code(HttpServletRequest request, HttpServletResponse response)
    {
        String name=request.getParameter("name");/*获取请求头中的信息*/
        ValueOperations<String,String> valueOperations=stringRedisTemplate.opsForValue();
        Code code=new Code();
        String data =String.valueOf(code.getCode());
        valueOperations.set(name,data,120, TimeUnit.SECONDS);/*将验证码存入redis，并设置失效时间*/
        return data;
    }
}
