package com.example.service.impl;

import com.example.entity.Buying;
import com.example.entity.Prebuying;
import com.example.mapper.SaleMapper;
import com.example.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Prebuying> findAll() {
        return saleMapper.findAll();

    }

    @Override
    public List<Prebuying> findById(Integer id) {
        return saleMapper.findById(id);

    }

    @Override
    public void create(Prebuying prebuying) {
        saleMapper.create(prebuying);

    }

    @Override
    public void delete(Integer id) {

        saleMapper.delete(id);
    }

    @Override
    public void update(Prebuying prebuying) {
        saleMapper.update(prebuying);
    }
}
