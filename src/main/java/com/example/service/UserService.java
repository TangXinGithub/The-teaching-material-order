package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    List<User> findById(Integer id);

    /**
     * 添加
     *
     * @param user
     */
    void create(User user);

    /**
     * 删除（批量）
     *
     * @param ids
     */
    void delete(Integer ids);

    /**
     * 修改
     *
     * @param user
     */
    void update(User user);
    /**
     * 根据名字查找
     *
     * @param name
     */
    User findByName(String name);
    public User login(String username,String password);
/*
    int register(User user);*/


}
