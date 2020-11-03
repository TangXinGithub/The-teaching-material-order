package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.service.UserService;

import java.util.List;




@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();

    }

    @Override
    public List<User> findById (Integer id) {
        return userMapper.findById(id);

    }

    @Override
   public void create(User user) {
        userMapper.create(user);

    }

    @Override
    public void delete(Integer ids) {

                userMapper.delete(ids);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }


    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
    @Override
    public User login(String username,String password){return userMapper.login(username,password);}
/*
    @Override
    public int register(User user){return userMapper.register(user);}*/

    //其他方法省略
}