package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.server.BookCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class GetBookComment {
    @Autowired
    private BookCommentMapper Book;
    @RequestMapping(value = "/Bookcomment")
    public String getbookComment(HttpServletRequest request)
    {
        try{
            String id = request.getParameter("book");
            int Id = Integer.parseInt(id);
            List<Map<String,Object>> list=Book.GetBookComment(Id);
            JSONObject jsonObject=new JSONObject();
            int i=0;
            for(Map map :list)
            {
                List list1=new ArrayList();
                list1.add(map.get("UserName"));
                list1.add(map.get("content"));
                list1.add(map.get("num"));
                list1.add(map.get("id"));
                jsonObject.put("comment"+i,list1);
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
