package com.example.tea.server;

import com.example.tea.dao.movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class movieMapper implements movie {
    @Autowired
    private movie dayMovie;
    @Override
    @Cacheable(value = "cashHome", key = "#DayMovie")
    public List<Map<String, Object>> getDayMovie(String DayMovie) {
        return dayMovie.getDayMovie(DayMovie);
    }

    @Override
    @Cacheable(value = "cashHome",key="#Num")
    public List<Map<String, Object>> GetAllMovie(int Num) {
        return dayMovie.GetAllMovie(Num);
    }

    @Override
    public Map GetMovie(int id) {
        return dayMovie.GetMovie(id);
    }

    @Override
    public List<Map<String, Object>> GetTypeMovie(String type, String address, int time1,int time2, int num) {
        return dayMovie.GetTypeMovie(type,address,time1,time2,num);
    }

    @Override
    public List<Map<String, Object>> GetMovieAddress(String type, int time1, int time2, int num) {
        return dayMovie.GetMovieAddress(type,time1,time2,num);
    }

    @Override
    public List<Map<String, Object>> GetMovieType(String address, int time1, int time2, int num) {
        return dayMovie.GetMovieType(address,time1,time2,num);
    }

    @Override
    public List<Map<String, Object>> GetMovieTime(String type, String addrss, int num) {
        return dayMovie.GetMovieTime(type,addrss,num);
    }

    @Override
    public List<Map<String, Object>> GetMovieAddType(int time1, int time2, int num) {
        return dayMovie.GetMovieAddType(time1,time2,num);
    }

    @Override
    public List<Map<String, Object>> GetMovieAddTime(String type, int num) {
        return dayMovie.GetMovieAddTime(type,num);
    }

    @Override
    public List<Map<String, Object>> GetMovieTypeTime(String address, int num) {
        return dayMovie.GetMovieTypeTime(address,num);
    }

    @Override
    public List<Map<String, Object>> GetATT(String address, String type, int time1, int time2, int num) {
        return dayMovie.GetATT(address,type,time1,time2,num);
    }

    @Override
    public void UserMark(int id, int mark, int movie) {
        dayMovie.UserMark(id,mark,movie);
    }

    @Override
    public int GetMovieMark(String name, int movie) {
        return dayMovie.GetMovieMark(name,movie);
    }

    @Override
    public List<Map<String, Object>> SearchMovie(String name) {
        return dayMovie.SearchMovie(name);
    }


}
