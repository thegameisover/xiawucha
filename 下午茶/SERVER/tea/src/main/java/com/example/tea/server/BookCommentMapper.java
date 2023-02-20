package com.example.tea.server;

import com.example.tea.dao.bookComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookCommentMapper implements bookComment {
    @Autowired
    private bookComment Book;
    @Override
    public void SetBookComment(String name, String content, int book) {
        Book.SetBookComment(name,content,book);
    }

    @Override
    public List<Map<String, Object>> GetBookComment(int book) {
        return Book.GetBookComment(book);
    }
}
