package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.server.GetPicture;
import com.example.tea.server.bookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
public class DayBook {

    @Autowired
    private bookMapper bookMapper;
    @Autowired
    private GetPicture getPicture;
    @RequestMapping(value = "/daybook")
    public String Book() throws IOException {
       try{
           List<Map<String,Object>> dayBook = bookMapper.NewBook("DayBook");
           JSONObject jsonObject = new JSONObject();
           int i=0;
           for(Map map : dayBook)
           {
               List<Object> list = new ArrayList<>();
               list.add(map.get("bookName"));
               String  picture=getPicture.getPicture((String)map.get("picture"));
               list.add(picture);
               list.add(map.get("id"));
               jsonObject.put("Book"+i,list);
               i++;
           }
           return jsonObject.toJSONString();
       }catch (Exception e)
       {
           return "false";
       }
    }
}
