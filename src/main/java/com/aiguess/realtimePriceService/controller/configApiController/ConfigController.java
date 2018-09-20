package com.aiguess.realtimePriceService.controller.configApiController;

import com.aiguess.common.ApiResponse;
import com.aiguess.common.DateUtils;
import com.aiguess.common.HttpStatusEnum;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigAppMapper;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigExportDbMapper;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigFieldsMapper;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderSourceFileCategoryMapper;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigApp;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigExportDb;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigFields;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderSourceFileCategory;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * config获取的api
 * @author kelen
 *
 */

@RestController
@RequestMapping("/api/config")
public class ConfigController {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SpiderConfigAppMapper spiderConfigAppMapper;

	@Resource
	private SpiderConfigFieldsMapper spiderConfigFieldsMapper;

	@Resource
	private SpiderConfigExportDbMapper spiderConfigExportDbMapper;

	@Resource
	private SpiderSourceFileCategoryMapper spiderSourceFileCategoryMapper;

	@Resource(name = "redisSpiderDatabase")
	private RedisTemplate redisSpiderDatabase;

	@RequestMapping("/updateRedis")
	public ApiResponse updateRedis(HttpServletRequest request){
	 	System.err.println("debug  demo");
	 	int id = Integer.parseInt(request.getParameter("app_id"));
	 	logger.debug("app_id:"+id);

//		ValueOperations<String, Object> ops = redisTradeDatabase.opsForValue();
//		System.err.println(ops.get("000002_1min"));
		logger.info(DateUtils.dateToStr(new Date()));

		SpiderConfigApp  spiderConfigApp = spiderConfigAppMapper.selectByPrimaryKey(id);
		List<SpiderConfigFields>  fields_list = spiderConfigFieldsMapper.getFieldsByAppId(id);
		// 字段这里要处理下
        HashMap<String, String> fields_list_model = new HashMap<>();
        for (SpiderConfigFields item: fields_list){
            fields_list_model.put(item.getFieldName(), item.getSelector());
        }

		//  start exportDB 这里只要一个
		SpiderConfigExportDb exportDb = spiderConfigExportDbMapper.getExportDbByAppId(id);
		//针对field要进行一下组装map,  json 字符串 {数据库字段：  映射字段}
		String fieldMapping = exportDb.getFieldMapping();

		//用阿里的alibab json
		JSONObject jso = JSONObject.parseObject(fieldMapping);
		Map<String, Object> jsonMap =  JSONObject.toJavaObject(jso, Map.class);

		HashMap<String, String>  column_field_mapping = new HashMap();

        Iterator<String>  ite = jsonMap.keySet().iterator();
        while (ite.hasNext()){
            String key = ite.next();

            SpiderConfigFields fields = spiderConfigFieldsMapper.selectByPrimaryKey(Integer.parseInt(jsonMap.get(key).toString()));

            column_field_mapping.put(key, fields.getFieldName());
        }
        exportDb.setFieldMapping(JSONObject.toJSON(column_field_mapping).toString());

        //这里处理完毕  export DB


		SpiderSourceFileCategory category = spiderSourceFileCategoryMapper.selectByPrimaryKey(spiderConfigApp.getCategoryId());

		JSONObject jsonObj = new JSONObject();

		//第一步  拿到分类
		HashMap<String, String> category_model = new HashMap<>();
		category_model.put("category_name", category.getCategoryName());
		category_model.put("file_store", category.getFileStore());
		category_model.put("all_nodes", category.getAllNodes());

		jsonObj.put("category_model", category_model);

		//2. 主要信息
		jsonObj.put("app_model", spiderConfigApp);

		//3.字段
		jsonObj.put("field_model", fields_list_model);

		//4.export DB
		jsonObj.put("exportDb_model", exportDb);

		logger.info(jsonObj.toString());


		//开始拼凑redis 的json String
		redisSpiderDatabase.opsForValue().set("spider:config:appId:"+id, jsonObj.toString());


//		logger.info(spiderConfigAppMapper.selectByPrimaryKey(1).getAppName());

		return new ApiResponse(HttpStatusEnum.OK.code(), "", HttpStatusEnum.OK.reasonPhraseUS());
	}  



}
