package com.example.controller;


import ch.qos.logback.core.joran.conditional.ElseAction;

import javax.validation.constraints.AssertFalse;
import javax.xml.transform.Result;
import java.sql.*;

public class mysql {


//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jiaocai?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC&allowMultiQueries=true";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "tangxin";
    static final String PASS = "123456";

    public  boolean conn(String sql) {
        Connection conn = null;
        Statement stmt = null;
        boolean result= false;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM"+tablename; //表名
            ResultSet rs = stmt.executeQuery(sql);

//           或者直接 返回结果

            if (!rs.next()|| rs==null) ;else result=true;
            System.out.println(rs.toString());
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索


            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
return result;
    }
}
