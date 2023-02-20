package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.bookCommentClass;
import com.example.tea.JavaClass.movieCommentClass;
import com.example.tea.server.BookCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetBookComment {
    @Autowired
    private BookCommentMapper Book;
    @RequestMapping(value = "/setBookcomment")
    public void SetbookComment(@RequestBody String data)
    {
        bookCommentClass comment = JSON.parseObject(data, bookCommentClass.class);
        Book.SetBookComment(comment.getName(),comment.getComment(),comment.getBook());
    }
}
