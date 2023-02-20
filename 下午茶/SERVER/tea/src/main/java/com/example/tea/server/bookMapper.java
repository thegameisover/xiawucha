package com.example.tea.server;

import com.example.tea.dao.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class bookMapper implements book {
    @Autowired
    private book Book;
    @Override
    @Cacheable(value = "cashHome", key = "#DayBook")
    public List<Map<String, Object>> NewBook(String DayBook) {
        return Book.NewBook("DayBook");
    }

    @Override
    public List<Map<String, Object>> AllBook(int num) {
        return Book.AllBook(num);
    }

    @Override
    @Cacheable(value = "cashHome",key="#id")
    public Map<String, Object> GetBook(int id) {
        return Book.GetBook(id);
    }

    @Override
    @Cacheable(value ="cashHome",key="#classification")
    public List<Map<String, Object>> classificationBook(String classification,int num) {
        return Book.classificationBook(classification,num);
    }

    @Override
    public void UserMark(int id, int mark,int book) {
        Book.UserMark(id,mark,book);
    }

    @Override
    public int GetMark(String name,int id) {
        return Book.GetMark(name,id);
    }

    @Override
    public List<Map<String, Object>> SearchBook(String name) {
        return Book.SearchBook(name);
    }
}
