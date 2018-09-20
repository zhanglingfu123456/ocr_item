package com.aiguess.realtimePriceService.controller.businessController;

import com.aiguess.common.ApiResponse;
import com.aiguess.common.HttpStatusEnum;
import com.aiguess.config.JdbcTemplate.JDBCTemplateDao;
import com.aiguess.config.JdbcTemplate.JDBCTemplateUtils;
import com.aiguess.realtimePriceService.entity.request.SpiderDataRequest;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 爬虫数据入库的controller接口
 * @Author:kaineng
 * @Description:
 * @Date:17:39 2018/9/13
 * @modified By:
 **/
@RestController
@RequestMapping("/api/spiderData")
public class SpiderDataController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResponse add(@RequestBody SpiderDataRequest request){
        logger.info("debug  request:"+JSONObject.toJSONString(request));

        Map db_config = request.getDbParamsMap();
        Map values = request.getValues();

        String fieldMapping = db_config.get("fieldMapping").toString();

        //用阿里的alibab json
        JSONObject jso = JSONObject.parseObject(fieldMapping);
        Map<String, String> fieldMap =  JSONObject.toJavaObject(jso, Map.class);

        String url = db_config.get("url").toString()+"/" + db_config.get("dbName").toString();
        logger.info(url);
        JdbcTemplate jdbcTemplate = JDBCTemplateUtils.getTemplate(url, db_config.get("username").toString(), db_config.get("password").toString() );

        JDBCTemplateDao jdbcTemplateDao = new JDBCTemplateDao(jdbcTemplate);
        jdbcTemplateDao.insert(db_config.get("tableName").toString(), fieldMap, values);


        return new ApiResponse(HttpStatusEnum.OK.code(), "", HttpStatusEnum.OK.reasonPhraseUS());
    }



}
