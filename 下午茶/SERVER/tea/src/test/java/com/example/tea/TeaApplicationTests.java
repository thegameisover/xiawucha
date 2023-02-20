package com.example.tea;

import com.alibaba.fastjson.JSONObject;
import com.example.tea.dao.User;
import com.example.tea.server.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@MapperScan("com.example.tea.dao")
class TeaApplicationTests {

@Autowired
private StringRedisTemplate stringRedisTemplate;
@Autowired
private User user;
@Autowired
private UserMapper userMapper;
@Autowired
private com.example.tea.server.bookMapper bookMapper;
@Autowired
private bookMapper bookMapper1;
@Autowired
private GetPicture getPicture;
@Autowired
private TimeMapper timeMapper;
@Autowired
private GettimePicture gettimePicture;
@Autowired
private questionMapper f;
@Autowired
private GetBookIntroduction getBookIntroduction;
@Autowired
private  movieMapper movieMapper1;
@Autowired
private movieCommentMapper movie;
@Autowired
private historyMapper history1;
    @Test
    void set() throws IOException {
       bookMapper1.SearchBook("阿");
    }
    @Test
    void get()
    {
        ValueOperations<String,String> valueOperations=stringRedisTemplate.opsForValue();
        System.out.println(valueOperations.get("张三"));
    }
}
