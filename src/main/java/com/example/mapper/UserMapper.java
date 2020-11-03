package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findById(Integer id);

    void create(User user);

    void delete(Integer id);

    void update(User user);

    User findByName(String name);
    User login(String username,String password);
/*    int register(User user);*/
}
