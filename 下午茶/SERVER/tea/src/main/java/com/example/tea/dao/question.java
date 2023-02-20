package com.example.tea.dao;

import java.util.List;
import java.util.Map;

public interface question {
    /*初识化10个问题*/
    public List<Map<String,Object>> getQuestion(String Question);
    /*获取10个新问题*/
    public List<Map<String,Object>> getNewQuestion(int page);

    /*获取问题详细信息*/
    public Map GetQuestion(int id);

    /*上传问题*/
    public void SetQuestion(String title,String name,String time,String picture1);

}
