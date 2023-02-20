package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.server.UserMapper;
import com.example.tea.server.historyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController

public class WRhistory {
    @Autowired
    private historyMapper historymapper;
    @Autowired
    private UserMapper userMapper;
    /*写入历史记录*/
    @RequestMapping(value = "/WriteHistory")
    public void SetHistory(HttpServletRequest request)
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
        if(account==null)
        {

        }
        else
        {
            int id =userMapper.getid(account);
            String Name = request.getParameter("name");
            historymapper.Write(Name,id);
        }

    }
    /*读入历史记录*/
    @RequestMapping(value = "/ReadHistory")
    public String GetHistory(HttpServletRequest request)
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
        }
        if(account==null)
        {
              return "请先登录";
        }
        else
        {
            int id =userMapper.getid(account);
            List<Map<String,Object>> list=historymapper.GetHistory(id);
            JSONObject jsonObject =new JSONObject();
            int i=0;
            for(Map map:list)
            {
                String name =(String)map.get("Name");
                jsonObject.put("json"+i,name);
                i++;
            }

            return jsonObject.toJSONString();
        }
    }

    @RequestMapping(value = "/deleteHistory")
    public void DeleteHistory(HttpServletRequest request)
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
        }
        if(account==null)
        {

        }
        else
        {
            int id= userMapper.getid(account);
            String name = request.getParameter("name");
            historymapper.deleteHistory(name,id);
        }
    }
}
