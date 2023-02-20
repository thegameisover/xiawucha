package com.example.tea.server;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetPicture {
    /*获取每日的书*/
    public String getPicture(String address) throws IOException {
        address= "Picture/"+address;
        return address;
    }

    public String SetPicture(String address)
    {
        address = "D:\\下午茶\\WEB\\question\\"+address;
        return address;
    }
}
