package com.aiguess.realtimePriceService.controller.configApiController;

import com.aiguess.common.ApiResponse;
import com.aiguess.common.DateUtils;
import com.aiguess.common.HttpStatusEnum;
import com.aiguess.common.MD5Utils;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigAppMapper;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigExportDbMapper;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderConfigFieldsMapper;
import com.aiguess.realtimePriceService.IDao.spiderConfigDao.SpiderUrlRecordMapper;
import com.aiguess.realtimePriceService.entity.request.FinFilterRequest;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigApp;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigExportDb;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderConfigFields;
import com.aiguess.realtimePriceService.entity.spiderConfig.SpiderUrlRecord;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * 爬虫去重表的获取的api
 * @author kelen
 *
 */

@RestController
@RequestMapping("/api/duplicate")
public class DuplicateController {

	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SpiderUrlRecordMapper spiderUrlRecordMapper;


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ApiResponse add(@RequestBody SpiderUrlRecord request){
	 	System.err.println("debug  add duplicate");
	 	request.setIsDelete((byte) 0);

	 	request.setCreateTime(new Date());

		String url = request.getUrl();
		String params = request.getParams();

		String url_params = params == null || params.length()==0 ? url : url +params;

		String url_params_md5 ="";
		try {
			url_params_md5 = MD5Utils.EncoderByMd5(url_params);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		request.setUrlParamsMd5(url_params_md5);
	 	spiderUrlRecordMapper.insert(request);

	 	return new ApiResponse(HttpStatusEnum.OK.code(), "", HttpStatusEnum.OK.reasonPhraseUS());
	}

	@RequestMapping(value = "/get")
	public ApiResponse get( HttpServletRequest request){
		System.err.println("debug  get duplicate");
		String url = request.getParameter("url");
		String params = request.getParameter("params");

		String url_params = params == null || params.length()==0 ? url : url +params;

		String url_params_md5 ="";
		try {
			url_params_md5 = MD5Utils.EncoderByMd5(url_params);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new ApiResponse(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), "", "NoSuchAlgorithmException");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ApiResponse(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), "", "UnsupportedEncodingException");
		}

		SpiderUrlRecord spiderUrlRecord = spiderUrlRecordMapper.getUrlRecord(url_params_md5);

		return new ApiResponse(HttpStatusEnum.OK.code(), spiderUrlRecord, HttpStatusEnum.OK.reasonPhraseUS());
	}




}
