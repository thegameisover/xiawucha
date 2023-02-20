package com.example.tea.dao;

import java.util.List;
import java.util.Map;

public interface movie {
    /*获取每日的电影推荐*/
    public List<Map<String,Object>> getDayMovie(String DayMovie);
    /*获取所有电影*/
    public List<Map<String,Object>> GetAllMovie(int Num);
    /*获取电影详细信息*/
    public Map GetMovie(int id);
    /*按条件查询电影*/
    /*全部条件不为空*/
    public List<Map<String,Object>> GetTypeMovie(String type,String address,int time1,int time2,int num);
    /*地区为空*/
    public List<Map<String,Object>> GetMovieAddress(String type,int time1,int time2,int num);
    /*类型为空*/
    public List<Map<String,Object>> GetMovieType(String address,int time1,int time2,int num);
    /*时间为空*/
    public List<Map<String,Object>> GetMovieTime(String type,String addrss,int num);
    /*地区和类型都为空*/
    public List<Map<String,Object>> GetMovieAddType(int time1,int time2,int num);
    /*地区和时间为空*/
    public List<Map<String,Object>> GetMovieAddTime(String type,int num);
    /*类型和时间为空*/
    public List<Map<String,Object>> GetMovieTypeTime(String address,int num);
    /*全部为空*/
    public List<Map<String,Object>> GetATT(String address,String type,int time1,int time2,int num);
    /*用户评分*/
    public void UserMark(int id,int mark,int movie);
    /*获取评分*/
    public int GetMovieMark(String name,int movie);
    /*模糊查询*/
    public List<Map<String,Object>> SearchMovie(String name);
}
