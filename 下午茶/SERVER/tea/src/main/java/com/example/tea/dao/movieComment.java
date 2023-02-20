package com.example.tea.dao;

import java.util.List;
import java.util.Map;

public interface movieComment {
    /*添加评论*/
    public void SetComment(String name,String content,int movie);
    /*获取评论*/
    public List<Map<String,Object>> GetComment(int id);
}
