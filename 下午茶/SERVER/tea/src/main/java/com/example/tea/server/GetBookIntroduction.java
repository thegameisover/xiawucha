package com.example.tea.server;

import org.springframework.stereotype.Service;

@Service
public class GetBookIntroduction {
    public String BookIntroduction(String address)
    {
        address = "D:\\下午茶\\SERVER\\tea\\src\\main\\java\\com\\example\\tea\\server\\BookIntroduction\\"+address;
        return address;
    }
}
