package com.aiguess.realtimePriceService.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.aiguess.common.ApiResponse;
import com.aiguess.common.DateUtils;
import com.aiguess.common.HttpStatusEnum;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigAppMapper;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.redis.core.RedisTemplate;
/**
 * springBoot 的一个demo
 * @author kelen
 *
 */

@RestController
@RequestMapping("demo")
public class DemoController {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SpiderConfigAppMapper spiderConfigAppMapper;


	@RequestMapping("/test1")  
	public ApiResponse test1(){
	 	System.err.println("debug  demo");

//		ValueOperations<String, Object> ops = redisTradeDatabase.opsForValue();
//		System.err.println(ops.get("000002_1min"));

		logger.info(DateUtils.dateToStr(new Date()));

		logger.info(spiderConfigAppMapper.selectByPrimaryKey(1).getAppName());
//	    return "demo1,test1()";

        return new ApiResponse(HttpStatusEnum.OK.code(), "", HttpStatusEnum.OK.reasonPhraseUS());
	}  

	 	
	@RequestMapping("/api")
	public HashMap<String, Object> api() {

		System.err.println("debug  json");
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("kelen", "123");

		Map request = new HashMap<>();
		request.put("list", new String[]{"002056", "600048"});

		return hashMap;
	}



	/**
	 * 事务的处理,测试
	 * 美股爬虫的amout刚好没用
	 */
	/*@RequestMapping("/transactionTest")
	@Transactional(value="caishenTransactionManager")
	public SpStockquoteUs testTransaction(HttpServletRequest request) {
		SpStockquoteUs  spStockquoteUs = spStockquoteUsMapper.selectByPrimaryKey("A.NYSE");
		spStockquoteUs.setAmount(60000.0);

		//更新
		spStockquoteUsMapper.updateByPrimaryKeySelective(spStockquoteUs);


		int a = 76/0;

		spStockquoteUs.setAmount(9999999.0);
		spStockquoteUsMapper.updateByPrimaryKeySelective(spStockquoteUs);

		return spStockquoteUsMapper.selectByPrimaryKey("A.NYSE");
	}*/
}
