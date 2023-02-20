package com.example.tea.server;

import org.springframework.stereotype.Service;

@Service
public class GettimePicture {
    /*轮播图*/
    public String time(String address)
    {
        address = "TimePicture/"+address;
        return address;
    }
}
