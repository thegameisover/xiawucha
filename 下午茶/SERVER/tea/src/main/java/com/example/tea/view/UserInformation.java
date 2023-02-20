package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tea.JavaClass.user;
import com.example.tea.dao.User;
import com.example.tea.server.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class UserInformation {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getUser")
    public String getUser(HttpServletRequest request)
    {
        Cookie[] cookies =request.getCookies();
        int n=0;
        String account=null;
        String password=null;
        if(cookies!=null)
        {
            for(Cookie cookie:cookies)
            {
                if(n==0)
                {
                    account=cookie.getValue();
                    n++;
                }
                else
                {
                    password=cookie.getValue();
                }
            }
        }
        if(account==null||password==null)
        {
            return null;
        }
        else
        {
            Map map = userMapper.getUser(account,password);
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("name",map.get("UserName"));
            jsonObject.put("account",map.get("account"));
            jsonObject.put("password",map.get("pass"));
            return jsonObject.toJSONString();
        }
    }

    @RequestMapping(value = "/userXinxi")
    public String modifyUser(@RequestBody String data, HttpServletRequest request, HttpServletResponse response)
    {
        Cookie[] cookies =request.getCookies();
        int n=0;
        String account=null;
        String password=null;
        if(cookies!=null)
        {
            for(Cookie cookie:cookies)
            {
                if(n==0)
                {
                    account=cookie.getValue();
                    n++;
                }
                else
                {
                    password=cookie.getValue();
                }
            }
        }
        if(account!=null||password!=null)
        {
            user user1=JSON.parseObject(data,user.class);
            userMapper.modifyUser(account,user1.getPassword(),user1.getUsername());
            Cookie cookie1 =new Cookie("account", user1.getAccount());
            Cookie cookie2 = new Cookie("password",user1.getPassword());
            cookie1.setMaxAge(24*30*30*60);
            cookie1.setPath("/");
            cookie2.setMaxAge(24*30*30*60);
            cookie2.setPath("/");
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        }
        return "true";
    }


}
