package com.aiguess.realtimePriceService.entity.request;

import java.util.HashMap;
import java.util.Map;

/**
 * spider 数据入库的api
 * @Author:kaineng
 * @Description:
 * @Date:20:52 2018/9/13
 * @modified By:
 **/
public class SpiderDataRequest {

    private HashMap<String, String> dbParamsMap;

    private HashMap<String, String> values;


    public HashMap<String, String> getDbParamsMap() {
        return dbParamsMap;
    }

    public void setDbParamsMap(HashMap<String, String> dbParamsMap) {
        this.dbParamsMap = dbParamsMap;
    }

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }
}
