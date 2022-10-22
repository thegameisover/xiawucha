package com.example.tea;

import com.example.tea.dao.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
@MapperScan("com.example.tea.dao")
class TeaApplicationTests {
   @Autowired
   private User user;

    @Test
    void set()
    {
        user.getId(1);
    }

}
