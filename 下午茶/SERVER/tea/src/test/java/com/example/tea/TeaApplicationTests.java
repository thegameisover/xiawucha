package com.example.tea;

import com.example.tea.dao.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@MapperScan("com.example.tea.dao")
class TeaApplicationTests {

@Autowired
private StringRedisTemplate stringRedisTemplate;
@Autowired
private User user;
    @Test
    void set()
    {
        String name= user.getName("123","123");
        System.out.println(name);

    }
    @Test
    void get()
    {
        ValueOperations<String,String> valueOperations=stringRedisTemplate.opsForValue();
        System.out.println(valueOperations.get("张三"));
    }
}
