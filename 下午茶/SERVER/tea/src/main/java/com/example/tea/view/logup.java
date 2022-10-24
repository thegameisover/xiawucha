package com.example.tea.view;

import com.example.tea.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logup {
    @Autowired
    private User user;
    @RequestMapping(value = "/logup",method = RequestMethod.POST)
    public String Logup(@RequestBody String data)
    {
        user User = 
    }
}
