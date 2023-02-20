package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.example.tea.JavaClass.userBook;
import com.example.tea.dao.User;
import com.example.tea.server.UserMapper;
import com.example.tea.server.bookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*用户评分*/
@RestController
public class UserBook {
    @Autowired
    private bookMapper Book;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/UserBook")
    public void bookMarking(@RequestBody String data)
    {
        userBook book = JSON.parseObject(data,userBook.class);
        int mark = Integer.parseInt(book.getMark());
        int id = userMapper.IdName(book.getName());
        Book.UserMark(id,mark,book.getBook());
    }
}
