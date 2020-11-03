package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.Buying;
import com.example.service.BuyingService;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class BuyingController {
    @Autowired
    private BuyingService buyingService;

     @RequestMapping("/buy/submit/textbook")
     @ResponseBody
    public Map<String, Object> add(/*@RequestBody */Buying buying) {

        Map<String, Object> modelMap = new HashMap<>();
        int add = buyingService.add(buying);
        if (add > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("msg", "添加失败");
        }
        return modelMap;
    }

    @RequestMapping("/query/textbook")
    public @ResponseBody String data(HttpServletRequest request, HttpServletResponse response){

//
//        Map<String, String[]> map = request.getParameterMap();
        List<Object> cloums =new ArrayList();

//        cloums.add("855ISBN52");
//        cloums.add("58Nnumber52");

        //maven 收入阿里巴巴的json处理插件
        JSONObject object = new JSONObject();
        object.put("ISBN","书一");
        object.put("number","数量222");

        //第二条数据
        JSONObject object2 = new JSONObject();
        object2.put("ISBN","书二");
        object2.put("number","5522");
//第三条数据
        JSONObject object3= new JSONObject();
        object3.put("ISBN","书三");
        object3.put("number","58512");

        //第n条数据 for

        // 加到list 里
        cloums.add(object);
        cloums.add(object2);
        cloums.add(object3);


         System.out.println(cloums);
         for(int i=0;i<3;i++) {

             buyingService.createAutoTaskResult('a'+String.valueOf(i),cloums);
         }

            //菜鸟教程copy
         mysql mysql= new mysql();
         String sql="";

            //直接用原生的sql查表
        for (int i=0;i<3;i++){

          sql="select * from information_schema.tables where table_name ='a"+i+"'";
//
          if(mysql.conn(sql)==true)//查询
          {
              sql = "select * from a" + i;
              mysql.conn(sql);
          }
//
// 如果表存在就查询，不存在就查，表名都不需要记（约定递增），把所有数据都返回
//            DROP TABLE [dbo].[表名]
        }

         return "helloword";
    }
//    public class CustomerController {
//        @PostMapping("/")
//        public Map<String, Object> getCustomerList(@RequestBody Buying buying) {
//            Map<String, Object> modelMap = new HashMap<>();
//            List<Buying> buyingList = buyingService.queryBuyingList();
//            //返回列表信息
//            modelMap.put("success", true);
//            modelMap.put("customerList", buyingList);
//            return modelMap;
//        }
//    }
}
