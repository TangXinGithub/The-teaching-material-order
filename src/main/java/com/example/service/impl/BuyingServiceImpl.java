package com.example.service.impl;

import com.example.entity.Buying;
import com.example.mapper.BuyingMapper;
import com.example.service.BuyingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class BuyingServiceImpl implements BuyingService {

    @Autowired
    private BuyingMapper buyingMapper;

    @Override
    public int add(Buying buying) {
        return buyingMapper.add(buying);
    }
    @Override
    public List<Buying> queryBuyingList() {
        return buyingMapper.queryBuyingList();
    }

    @Override
    public void addStatus(Integer id) { buyingMapper.addStatus(id); }
    @Override
    public void createAutoTaskResult(@Param("tableName")String tableName, @Param("cloums")List<Object> cloums){
        buyingMapper.createAutoTaskResult(tableName,cloums);
    }

    @Override
    public void createtable(String tablename) {
        buyingMapper.createtable(tablename);
    }

    /**
     * @Description: 单纯返回id作为key的map
     * @MapKey("id")
     * Map<Long, Object> selectTaskResult(@Param("tableName")String tableName, @Param("startDate")Date startDate, @Param("endDate")Date endDate)
     */
    @Override
    public List<Map<String, Object>> selectTaskResult(@Param("tableName")String tableName, @Param("startDate") Date startDate, @Param("endDate")Date endDate){
        return buyingMapper.selectTaskResult(tableName,startDate,endDate);
    }
}
