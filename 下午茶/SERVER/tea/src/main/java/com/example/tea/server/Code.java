package com.example.tea.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Code {

    //生成随机数(验证码)；
     public int getCode()
     {
         Random random =new Random();
         return random.nextInt(900)+100;
     }
}
