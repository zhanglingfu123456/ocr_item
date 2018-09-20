package com.aiguess.realtimePriceService;

/**
 * @Author:kaineng
 * @Description:
 * @Date:11:34 2018/9/13
 * @modified By:
 **/

import com.aiguess.config.JdbcTemplate.JDBCTemplateUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplateTest {

    @Test
    public void test1() {

//        // JDBC模板依赖于连接池来获得数据的连接，所以必须先要构造连接池
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/data-pipeline");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//
//        // 创建JDBC模板
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        // 这里也可以使用构造方法
//        jdbcTemplate.setDataSource(dataSource);


        JdbcTemplate jdbcTemplate = JDBCTemplateUtils.getTemplate("localhost:3306/data-pipeline","root" , "root");

        // 查询sql语句
        String sql = "select count(*)  from spider_config_fields";
        Long num = (long) jdbcTemplate.queryForObject(sql, Long.class);

        System.out.println(num);



        //插入成功
        String update_sql = "insert into spider_config_fields (app_id, field_name, selector, required) values (?, ?, ?, ?)";

        //这里字符串和整数都可以
        System.err.print(jdbcTemplate.update(update_sql, "1", "title2", "//div", "2"));




    }




}