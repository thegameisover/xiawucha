package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.dao.User;
import com.example.tea.server.GetBookIntroduction;
import com.example.tea.server.GetPicture;
import com.example.tea.server.bookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BookShow {
    @Autowired
    private com.example.tea.server.bookMapper bookMapper;
    @Autowired
    private GetPicture getPicture;
    @Autowired
    private GetBookIntroduction getBookIntroduction;
    @Autowired
    private User user;
    @RequestMapping(value = "/AllBook")
    public String BookAll(HttpServletRequest servletRequest)
    {
        String num =servletRequest.getParameter("num");
        /*图书表分页后的页号*/
        int page = Integer.parseInt(num);
        try{
            List<Map<String,Object>> list=bookMapper.AllBook(page);
            if(list.size()==0)
            {
                return "null";
            }
            JSONObject jsonObject = new JSONObject();
            int i=0;
            for(Map map : list)
            {
                List list1 =new ArrayList();
                list1.add(map.get("bookName"));
                String  picture=getPicture.getPicture((String)map.get("picture"));
                list1.add(picture);
                list1.add(map.get("id"));
                jsonObject.put("book"+i,list1);
                i++;
            }
            return jsonObject.toJSONString();
        }catch (Exception e)
        {
          return "false";
        }
    }

    @RequestMapping(value = "/Book")
    public String ReadBook(HttpServletRequest request)
    {
        String id = request.getParameter("id");
        int Id = Integer.parseInt(id);
        Cookie [] cookies = request.getCookies();
        String account=null;
        String password=null;
        int n=0;
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
        String name = user.getName(account,password);
        JSONObject jsonObject =new JSONObject();
        try{
            int mark = bookMapper.GetMark(name,Id);
            jsonObject.put("mark",mark);
        }
        catch (Exception e)
        {
            jsonObject.put("mark",0);
        }
        try{
            Map<String ,Object> map =bookMapper.GetBook(Id);
            jsonObject.put("id",map.get("id"));
            jsonObject.put("bookName",map.get("bookName"));
            jsonObject.put("country",map.get("country"));
            jsonObject.put("writer",map.get("writer"));
            jsonObject.put("value",map.get("mark"));
            String  picture=getPicture.getPicture((String)map.get("picture"));
            jsonObject.put("picture",picture);
            String file= getBookIntroduction.BookIntroduction((String)map.get("introduction"));
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer stringBuffer =new StringBuffer();
            String data=null;
            while( (data=br.readLine())!=null)
            {
                stringBuffer.append(data);
            }
            data=stringBuffer.toString();
            jsonObject.put("content",data);
            isr.close();
            br.close();
            if(name==null)
            {
                jsonObject.put("name","null");
            }
            else
            {
                jsonObject.put("name",name);
            }
            return jsonObject.toJSONString();
        }catch (Exception e)
        {
          return "null";
        }
    }

    @RequestMapping(value = "/classificationBook")
    public String Search(HttpServletRequest request)
    {
        String data=request.getParameter("type");
        String id = request.getParameter("id");
        int Id = Integer.parseInt(id);
        try{
            List<Map<String,Object>> list =bookMapper.classificationBook(data,Id);
            if(list.size()==0)
            {
                return "null";
            }
            JSONObject jsonObject =new JSONObject();
            int i=0;
            for(Map map :list)
            {
                List list1 =new ArrayList();
                list1.add(map.get("bookName"));
                list1.add(map.get("id"));
                String picture = getPicture.getPicture((String)map.get("picture"));
                list1.add(picture);
                jsonObject.put("json"+i,list1);
                i++;
            }
            return jsonObject.toJSONString();
        }
        catch (Exception e)
        {
             return "false";
        }
    }
}
