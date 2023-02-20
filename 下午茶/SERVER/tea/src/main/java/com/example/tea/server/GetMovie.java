package com.example.tea.server;

import org.springframework.stereotype.Service;

@Service
public class GetMovie {
    /*获取每日电影*/
    public String getMovie(String address)
    {
        address = "Movie/"+address;
        return address;
    }
}
