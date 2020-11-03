package com.example.mapper;

import com.example.entity.Buying;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface BuyingMapper {


    List<Buying> queryBuyingList();
    int  add(Buying buying);
    void addStatus(Integer id);
    void createAutoTaskResult(@Param("tableName")String tableName, @Param("cloums")List<Object> cloums);
    void createtable(@Param("tablename")String tablename);
    /**
     * @Description: 单纯返回id作为key的map
     * @MapKey("id")
     * Map<Long, Object> selectTaskResult(@Param("tableName")String tableName, @Param("startDate")Date startDate, @Param("endDate")Date endDate)
     */

    List<Map<String, Object>> selectTaskResult(@Param("tableName")String tableName, @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
