package com.example.tea.dao;

import java.util.List;
import java.util.Map;

public interface book {
       /*每日推荐*/
       public List<Map<String,Object>> NewBook(String DayBook);
       /*全部图书*/
       public List<Map<String,Object>> AllBook(int num);
       /*图书详细信息*/
       public Map<String,Object> GetBook(int id);
       /*分类查询*/
       public List<Map<String,Object>> classificationBook(String classification,int num);
       /*用户的评分*/
       public void UserMark(int id,int mark,int book);
       /*查询用户评分*/
       public int GetMark(String name,int id);

       /*模糊查询*/
       public List<Map<String,Object>> SearchBook(String name);

}
