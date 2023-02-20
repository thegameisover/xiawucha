package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.movieMark;
import com.example.tea.dao.User;
import com.example.tea.server.UserMapper;
import com.example.tea.server.movieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMovie {
    @Autowired
    private movieMapper movie;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/MovieMark")
    public void MovieMark(@RequestBody String data)
    {
        try{
            movieMark mark = JSON.parseObject(data,movieMark.class);
            int id =userMapper.IdName(mark.getName());
            movie.UserMark(id,mark.getMark(),mark.getMovie());
        }
        catch (Exception e)
        {

        }
    }
}
