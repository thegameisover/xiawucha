package com.example.tea.server;

import com.example.tea.dao.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class questionMapper implements question {
    @Autowired
    private question question1;
    @Override

    public List<Map<String, Object>> getQuestion(String Question) {
        return question1.getQuestion(Question);
    }

    @Override
    public List<Map<String, Object>> getNewQuestion(int page) {
        return question1.getNewQuestion(page);
    }

    @Override
    public Map GetQuestion(int id) {
        return question1.GetQuestion(id);
    }

    @Override
    public void SetQuestion(String title, String name, String time, String picture1) {
        question1.SetQuestion(title,name,time,picture1);
    }
}
