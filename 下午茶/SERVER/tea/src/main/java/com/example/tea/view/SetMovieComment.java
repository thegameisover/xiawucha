package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.movieCommentClass;
import com.example.tea.server.movieCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SetMovieComment {
    @Autowired
    private movieCommentMapper movie;
    @RequestMapping(value = "/moviecomment")
    public void moviecomment(@RequestBody String data)
    {
        movieCommentClass comment = JSON.parseObject(data, movieCommentClass.class);
        movie.SetComment(comment.getName(),comment.getComment(),comment.getMovie());
    }
}
