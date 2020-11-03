package com.example.mapper;

import com.example.entity.Buying;
import com.example.entity.Prebuying;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
public interface SaleMapper {
    List<Prebuying> findAll();

    List<Prebuying> findById(Integer id);

    void create(Prebuying prebuying);

    void delete(Integer id);

    void update(Prebuying prebuying);
}
