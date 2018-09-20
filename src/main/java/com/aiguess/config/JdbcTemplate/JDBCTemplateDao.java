package com.aiguess.config.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.Map;

/**
 * jdbc 执行插入操作
 * @Author:kaineng
 * @Description:
 * @Date:11:56 2018/9/13
 * @modified By:
 **/
public class JDBCTemplateDao {

    private JdbcTemplate jdbcTemplate;

    public JDBCTemplateDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *
     * @param table_name
     * @param dbParamsMap  字段映射的map   key是数据库字段   value是映射字段
     * @param valuesMap
     * @return
     */
    public int insert(String table_name, Map<String, String> dbParamsMap, Map<String, String> valuesMap){

        //开始拼凑 field和value ?
        String field_str = "";
        String value_str = "";
        String[] update_arr = new String[dbParamsMap.size()];

        Iterator<String> it = dbParamsMap.keySet().iterator();
        int cursor = 0;
        while (it.hasNext()){
            String key = it.next();
            field_str += (field_str.length() == 0 ? key : ","+key);
            value_str += (value_str.length() == 0 ? "?" : ", ?");

            update_arr[cursor] = valuesMap.get(dbParamsMap.get(key));
            cursor++;
        }

        field_str = "(" + field_str +")";
        value_str = "(" + value_str +")";

        //插入成功
        String update_sql = "insert into " + table_name+ field_str + " values " + value_str;

        System.err.print("update_sql is" + update_sql);

        //这里字符串和整数都可以
        int result = jdbcTemplate.update(update_sql, update_arr);

        System.err.print("result is" + result);
        return result;
    }


}
