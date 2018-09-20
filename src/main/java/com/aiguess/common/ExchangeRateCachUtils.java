package com.aiguess.common;

/**
 * 拼凑实时汇率的redis的key
 * @author kelen
 * @date 2018年4月18日 下午2:47:17
 */
public class ExchangeRateCachUtils {
	
	public final static String PREFIX = "exchangeRate";
	
	
	public static String getKey(String from_currency_code, String to_currency_code){
		return PREFIX+":"+from_currency_code+":"+to_currency_code;
	}

}
