package com.example.service;

import com.example.entity.Buying;
import com.example.entity.Prebuying;

import java.util.List;

public interface SaleService {
    List<Prebuying> findAll();

    List<Prebuying> findById(Integer id);

    void create(Prebuying prebuying);

    void delete(Integer id);

    void update(Prebuying prebuying);


}
