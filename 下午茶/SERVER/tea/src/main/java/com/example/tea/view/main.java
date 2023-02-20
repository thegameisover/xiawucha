package com.example.tea.view;

import com.example.tea.server.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class main {
    @Autowired
   private UserMapper userMapper;
    @RequestMapping(value = "/main")
    public String Main(HttpServletResponse response, HttpServletRequest request)
    {
        Cookie [] cookies =request.getCookies();
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
            return userMapper.getName(account,password);
        }
        return "";
    }
}
