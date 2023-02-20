package com.example.tea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.example.tea.dao")
public class TeaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeaApplication.class, args);
    }
}
