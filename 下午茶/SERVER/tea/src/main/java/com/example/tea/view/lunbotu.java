package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.server.GettimePicture;
import com.example.tea.server.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*传送轮播图*/
@RestController
public class lunbotu {
    @Autowired
    private TimeMapper timeMapper;
    @Autowired
    private GettimePicture gettimePicture;
    @RequestMapping(value = "/timepicture")
    public String daymovie()
    {
        try
        {
            List<Map<String,Object>> list =timeMapper.timePicture("TimePicture");
            JSONObject jsonObject = new JSONObject();
            int i=0;
            for(Map map : list)
            {
                List list1 = new ArrayList<>();
                list1.add(map.get("id"));
                String address = gettimePicture.time((String)map.get("Picture"));
                list1.add(address);
                jsonObject.put("Time"+i,list1);
                i++;
            }
            return jsonObject.toJSONString();
        }catch (Exception e)
        {
          return "false";
        }
    }
}
