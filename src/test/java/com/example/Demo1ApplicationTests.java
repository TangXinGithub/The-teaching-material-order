package com.example;

import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired(required=false)
    private UserService usermapper;

    @Test
    public void test(){

        usermapper.findAll();

    }

}
