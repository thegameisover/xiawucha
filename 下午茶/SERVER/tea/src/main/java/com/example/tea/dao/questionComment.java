package com.example.tea.dao;

import java.util.List;
import java.util.Map;

public interface questionComment {
    /*获取评论*/
    public List<Map<String,Object>> GetQuestion(int id);
    /*添加评论*/
    public void SetQuestion(String name,String content,int question);
}
