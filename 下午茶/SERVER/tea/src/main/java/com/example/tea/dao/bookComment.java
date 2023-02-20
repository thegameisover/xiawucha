package com.example.tea.dao;

import java.util.List;
import java.util.Map;

public interface bookComment {
    /*添加评论*/
    public void SetBookComment(String name,String content,int book);
    /*获取评论*/
    public List<Map<String,Object>> GetBookComment(int book);
}
