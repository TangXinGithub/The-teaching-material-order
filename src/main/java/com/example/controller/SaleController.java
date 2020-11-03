package com.example.controller;

import com.example.entity.Buying;
import com.example.entity.Prebuying;
import com.example.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @RequestMapping("/buy/textbook")
    @ResponseBody
    public List<Prebuying> findAll() { //return userService.findAll();
        List<Prebuying> prebuyings = saleService.findAll();
        return prebuyings;
    }


}
