package com.example.tea.server;

import org.springframework.stereotype.Service;

@Service
public class GetMovieAddress {
    public String getAddress(String address)
    {
        address = "D:\\下午茶\\SERVER\\tea\\src\\main\\java\\com\\example\\tea\\server\\MovieIntroduction\\"+address;
        return address;
    }
}
