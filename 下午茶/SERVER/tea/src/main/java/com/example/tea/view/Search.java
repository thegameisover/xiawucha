package com.example.tea.view;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class Search {
    @Autowired
    private bookMapper book;
    @Autowired
    private movieMapper movie;
    @Autowired
    private GetPicture getPicture;
    @Autowired
    private GetMovie getMovie;

    @RequestMapping(value = "/SearchBook")
    public String GetBook(HttpServletRequest request) throws IOException {
        String name = request.getParameter("search");
        List<Map<String,Object>> list = book.SearchBook(name);
        JSONObject jsonObject =new JSONObject();
        int i=0;
        for(Map map :list)
        {
            List<Object> list1 = new ArrayList<>();
            list1.add(map.get("bookName"));
            String  picture=getPicture.getPicture((String)map.get("picture"));
            list1.add(picture);
            list1.add(map.get("id"));
            jsonObject.put("Book"+i,list1);
            i++;
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping(value = "/SearchMovie")
    public String GetMovie(HttpServletRequest request) throws IOException {
        String name = request.getParameter("search");
        List<Map<String,Object>> list = movie.SearchMovie(name);
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
    }
}
