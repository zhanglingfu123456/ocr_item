package com.aiguess.config.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 获取jdbcTemplate的连接
 * @Author:kaineng
 * @Description:
 * @Date:11:25 2018/9/13
 * @modified By:
 **/
public class JDBCTemplateUtils {

    public static JdbcTemplate getTemplate(String url, String userName, String passWord){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://"+url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        return jdbcTemplate;
    }

}
