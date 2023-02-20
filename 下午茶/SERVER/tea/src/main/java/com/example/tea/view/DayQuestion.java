package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DayQuestion {
    @Autowired
    private com.example.tea.server.questionMapper questionMapper1;
    @RequestMapping(value = "/question")
    public String getQuestion()
    {
        try
        {
            System.out.println("1");
            List<Map<String,Object>> list =questionMapper1.getQuestion("question");
            JSONObject jsonObject =new JSONObject();
            int i=0;
            for(Map map :list)
            {
                 List list1 =new ArrayList();
                 list1.add(map.get("id"));
                 list1.add(map.get("title"));
                 list1.add(map.get("name"));
                 list1.add(map.get("writeTime"));
                 list1.add(map.get("num"));
                 jsonObject.put("Question"+i,list1);
                 i++;
            }
            return jsonObject.toJSONString();
        }catch (Exception e)
        {
             return "false";
        }
    }


    @RequestMapping(value = "/NewQuestion")
    public String GetNewQuestion(HttpServletRequest request)
    {
        try{
            String page = request.getParameter("page");
            int id = Integer.parseInt(page);
            System.out.println(id);
            List<Map<String,Object>> list = questionMapper1.getNewQuestion(id);
             if(list.size()==0)
             {
                 return "null";
             }

             JSONObject jsonObject =new JSONObject();
             int i=0;
             for(Map map :list)
             {
                 List list1 =new ArrayList();
                 list1.add(map.get("id"));
                 list1.add(map.get("title"));
                 list1.add(map.get("name"));
                 list1.add(map.get("writeTime"));
                 list1.add(map.get("num"));
                 jsonObject.put("Question"+i,list1);
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
