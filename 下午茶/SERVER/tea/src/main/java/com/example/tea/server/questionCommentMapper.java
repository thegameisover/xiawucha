package com.example.tea.server;

import com.example.tea.dao.questionComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class questionCommentMapper implements questionComment {
    @Autowired
    private questionComment questioncomment;
    @Override
    public List<Map<String, Object>> GetQuestion(int id) {
        return questioncomment.GetQuestion(id);
    }

    @Override
    public void SetQuestion(String name, String content, int question) {
          questioncomment.SetQuestion(name,content,question);
    }
}
