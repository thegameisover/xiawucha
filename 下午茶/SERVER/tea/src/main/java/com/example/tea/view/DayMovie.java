package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.server.GetMovie;
import com.example.tea.server.movieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*获取每日电影推荐*/
@RestController
public class DayMovie {
    @Autowired
    private GetMovie getMovie;
    @Autowired
    private com.example.tea.server.movieMapper movieMapper;
    @RequestMapping(value = "/dayMovie")
    public String daymovie()
    {
        try{
            List<Map<String,Object>> list = movieMapper.getDayMovie("dayMovie");
            JSONObject jsonObject = new JSONObject();
            int i=0;
            for(Map map:list)
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

}
