package com.example.tea.server;

import com.example.tea.dao.movieComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class movieCommentMapper implements movieComment {
    @Autowired
    private movieComment movie1;
    @Override
    public void SetComment(String name, String content, int movie) {
        movie1.SetComment(name,content,movie);
    }

    @Override
    public List<Map<String, Object>> GetComment(int id) {
        return movie1.GetComment(id);
    }
}
