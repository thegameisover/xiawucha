package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tea.JavaClass.Movie;
import com.example.tea.server.GetMovie;
import com.example.tea.server.GetMovieAddress;
import com.example.tea.server.UserMapper;
import com.example.tea.server.movieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MovieShow {
    @Autowired
    private movieMapper movieMapper1;
    @Autowired
    private GetMovie getMovie;
    @Autowired
    private GetMovieAddress getMovieAddress;
    @Autowired
    private UserMapper user;
    @RequestMapping(value = "/AllMovie")
    public String AllMovie(HttpServletRequest request)
    {
        String id = request.getParameter("num");
        int Id = Integer.parseInt(id);
        try{
            List<Map<String,Object>> list = movieMapper1.GetAllMovie(Id);
            if(list.size()==0)
            {
                return "null";
            }
            JSONObject jsonObject =new JSONObject();
            int i=0;
            for(Map map :list)
            {
                List list1 = new ArrayList();
                list1.add(map.get("id"));
                list1.add(map.get("movieName"));
                list1.add(map.get("mark"));
                String address = getMovie.getMovie((String)map.get("picture"));
                list1.add(address);
                jsonObject.put("Movie"+i,list1);
                i++;
            }
            return jsonObject.toJSONString();
        }catch (Exception e)
        {
            return "false";
        }
    }

    @RequestMapping(value = "/ReadMovie")
    public String ReadMovie(HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
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
        String id = request.getParameter("id");
        int Id = Integer.parseInt(id);
        JSONObject jsonObject =new JSONObject();
        if(name==null)
        {
           jsonObject.put("name","null");
        }
        else
        {
            jsonObject.put("name",name);
        }
        try{
            int mark=movieMapper1.GetMovieMark(name,Id);
            jsonObject.put("markMovie",mark);
        }catch (Exception e)
        {
           jsonObject.put("markMovie",0);
        }
        try{
              Map map = movieMapper1.GetMovie(Id);
              jsonObject.put("id",map.get("id"));
              jsonObject.put("movieName",map.get("movieName"));
              jsonObject.put("director",map.get("director"));
              jsonObject.put("country",map.get("country"));
              jsonObject.put("movieType",map.get("movieType1"));
              jsonObject.put("mark",map.get("mark"));
              jsonObject.put("time",map.get("time"));
              String picture = getMovie.getMovie((String)map.get("picture"));
              jsonObject.put("picture",picture);
              String address = getMovieAddress.getAddress((String)map.get("introduction"));
            InputStreamReader isr = new InputStreamReader(new FileInputStream(address),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer stringBuffer =new StringBuffer();
            String data=null;
            while ((data= br.readLine())!=null)
            {
                stringBuffer.append(data);
            }
            isr.close();
            br.close();
            data=stringBuffer.toString();
            jsonObject.put("introduction",data);
            return jsonObject.toJSONString();

        }catch (Exception e)
        {
          return "false";
        }
    }

    @RequestMapping(value = "/MovieType")
    public String SearchMovie(@RequestBody String body)
    {
         Movie movie = JSON.parseObject(body,Movie.class);

         if(movie.getAddress().equals("null")&&!movie.getTime().equals("null")&&!movie.getType().equals("null"))
         {

             try{
                 int time = Integer.parseInt(movie.getTime());
                 int time1=time+10;
                 List<Map<String,Object>> list =movieMapper1.GetMovieAddress(movie.getType(),time,time1,movie.getPage());
                 if(list.size()==0)
                 {
                     return "null";
                 }
                 JSONObject jsonObject = new JSONObject();
                 int i=0;
                 for(Map map :list)
                 {
                     List list1 = new ArrayList();
                     list1.add(map.get("id"));
                     list1.add(map.get("movieName"));
                     list1.add(map.get("mark"));
                     String address = getMovie.getMovie((String)map.get("picture"));
                     list1.add(address);
                     jsonObject.put("Movie"+i,list1);
                     i++;
                 }
                 return jsonObject.toJSONString();
             }
             catch (Exception e)
             {
                 return "false";
             }
         }
         else if(!movie.getAddress().equals("null")&&movie.getTime().equals("null")&& !movie.getType().equals("null"))
         {

             try {
                 List<Map<String, Object>> list = movieMapper1.GetMovieTime(movie.getAddress(), movie.getType(), movie.getPage());
                 if (list.size() == 0) {
                     return "null";
                 }
                 JSONObject jsonObject = new JSONObject();
                 int i = 0;
                 for (Map map : list) {
                     List list1 = new ArrayList();
                     list1.add(map.get("id"));
                     list1.add(map.get("movieName"));
                     list1.add(map.get("mark"));
                     String address = getMovie.getMovie((String) map.get("picture"));
                     list1.add(address);
                     jsonObject.put("Movie" + i, list1);
                     i++;
                 }
                 return jsonObject.toJSONString();
             }
             catch (Exception e)
             {
                 return "false";
             }
         }
         else if(!movie.getAddress().equals("null")&& !movie.getTime().equals("null")&&movie.getType().equals("null"))
         {

             try{
                 int time = Integer.parseInt(movie.getTime());
                 int time1=time+10;
                 List<Map<String,Object>> list =movieMapper1.GetMovieType(movie.getAddress(),time,time1,movie.getPage());
                 if(list.size()==0)
                 {
                     return "null";
                 }
                 JSONObject jsonObject =new JSONObject();
                 int i=0;
                 for(Map map :list)
                 {
                     List list1 = new ArrayList();
                     list1.add(map.get("id"));
                     list1.add(map.get("movieName"));
                     list1.add(map.get("mark"));
                     String address = getMovie.getMovie((String) map.get("picture"));
                     list1.add(address);
                     jsonObject.put("Movie" + i, list1);
                     i++;
                 }
                 return jsonObject.toJSONString();
             }
             catch (Exception e)
             {
                 return "false";
             }
         }
         else if(movie.getAddress().equals("null")&& !movie.getTime().equals("null")&&movie.getType().equals("null"))
         {

             try {
                 int time = Integer.parseInt(movie.getTime());
                 int time1 = time + 10;
                 List<Map<String, Object>> list = movieMapper1.GetMovieAddType(time, time1, movie.getPage());
                 if (list.size() == 0) {
                     return "null";
                 }
                 JSONObject jsonObject = new JSONObject();
                 int i = 0;
                 for (Map map : list) {
                     List list1 = new ArrayList();
                     list1.add(map.get("id"));
                     list1.add(map.get("movieName"));
                     list1.add(map.get("mark"));
                     String address = getMovie.getMovie((String) map.get("picture"));
                     list1.add(address);
                     jsonObject.put("Movie" + i, list1);
                     i++;
                 }
                 return jsonObject.toJSONString();
             }
             catch (Exception e)
             {
                 return "false";
             }
         }
         else if(movie.getAddress().equals("null")&&movie.getTime().equals("null")&& ! (movie.getType().equals("null")))
         {

              try{
                  List<Map<String,Object>> list =movieMapper1.GetMovieAddTime(movie.getType(),movie.getPage());
                  if(list.size()==0)
                  {
                      return "null";
                  }
                  JSONObject jsonObject =new JSONObject();
                  int i=0;
                  for(Map map :list)
                  {
                      List list1 = new ArrayList();
                      list1.add(map.get("id"));
                      list1.add(map.get("movieName"));
                      list1.add(map.get("mark"));
                      String address = getMovie.getMovie((String) map.get("picture"));
                      list1.add(address);
                      jsonObject.put("Movie" + i, list1);
                      i++;
                  }
                  return jsonObject.toJSONString();
              }catch (Exception e)
              {
                  return "false";
              }
         }
         else if( !movie.getAddress().equals("null")&&movie.getTime().equals("null")&&movie.getType().equals("null"))
         {

              try{
                  List<Map<String,Object>> list=movieMapper1.GetMovieTypeTime(movie.getAddress(),movie.getPage());
                  if(list.size()==0)
                  {
                      return "null";
                  }
                  JSONObject jsonObject =new JSONObject();
                  int i=0;
                  for(Map map : list)
                  {
                      List list1 = new ArrayList();
                      list1.add(map.get("id"));
                      list1.add(map.get("movieName"));
                      list1.add(map.get("mark"));
                      String address = getMovie.getMovie((String) map.get("picture"));
                      list1.add(address);
                      jsonObject.put("Movie" + i, list1);
                      i++;
                  }
                  return jsonObject.toJSONString();
              }catch (Exception e)
              {
                  return "false";
              }
         }
         else if(movie.getAddress().equals("null")&&movie.getTime().equals("null")&&movie.getType().equals("null"))
         {

             try{
                 List<Map<String,Object>> list = movieMapper1.GetAllMovie(movie.getPage());
                 if(list.size()==0)
                 {
                     return "null";
                 }
                 JSONObject jsonObject =new JSONObject();
                 int i=0;
                 for(Map map :list)
                 {
                     List list1 = new ArrayList();
                     list1.add(map.get("id"));
                     list1.add(map.get("movieName"));
                     list1.add(map.get("mark"));
                     String address = getMovie.getMovie((String)map.get("picture"));
                     list1.add(address);
                     jsonObject.put("Movie"+i,list1);
                     i++;
                 }
                 return jsonObject.toJSONString();
             }catch (Exception e)
             {
                 return "false";
             }
         }
         else
         {

             try{
                 int time = Integer.parseInt(movie.getTime());
                 int time1 = time + 10;
                 List<Map<String, Object>> list = movieMapper1.GetATT(movie.getAddress(),movie.getType(),time, time1, movie.getPage());
                 if (list.size() == 0) {
                     return "null";
                 }
                 JSONObject jsonObject = new JSONObject();
                 int i = 0;
                 for (Map map : list) {
                     List list1 = new ArrayList();
                     list1.add(map.get("id"));
                     list1.add(map.get("movieName"));
                     list1.add(map.get("mark"));
                     String address = getMovie.getMovie((String) map.get("picture"));
                     list1.add(address);
                     jsonObject.put("Movie" + i, list1);
                     i++;
                 }
                 return jsonObject.toJSONString();
             }catch (Exception e)
             {
                 return "false";
             }
         }
    }
}
