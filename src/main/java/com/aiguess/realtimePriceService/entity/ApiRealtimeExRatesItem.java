package com.aiguess.realtimePriceService.entity;

/**
 * alpha vantage 实时汇率的body
 * @author kelen
 * @date 2018年4月18日 
 *  
 *  {
 *  1. From_Currency Code	"BTC"
2. From_Currency Name	"Bitcoin"
3. To_Currency Code	"EUR"
4. To_Currency Name	"Euro"
5. Exchange Rate	"6389.67155806"
6. Last Refreshed	"2018-04-18 03:01:21"
7. Time Zone	"UTC"
   }
 */
public class ApiRealtimeExRatesItem {
	
	/**
	 * 固定的key
	 */
	public static String FROM_CURRENCY_CODE = "1. From_Currency Code";
	
	public static String FROM_CURRENCY_NAME = "2. From_Currency Name";
	
	public static String TO_CURRENCY_CODE = "3. To_Currency Code";
	
	public static String TO_CURRENCY_NAME = "4. To_Currency Name";
	
	public static String EXCHANGE_RATE = "5. Exchange Rate";
	
	public static String LAST_REFRESHED = "6. Last Refreshed";
	
	public static String TIME_ZONE = "7. Time Zone";
	
	
	/**
	 * 真正的属性
	 */
	private  String from_currency_code ;
	
	private  String from_currency_name ;
	
	private  String to_currency_code ;
	
	private  String to_currency_name;
	
	private  String exchange_rate ;
	
	private  String last_refreshed ;
	
	private  String time_zone ;

	public String getFrom_currency_code() {
		return from_currency_code;
	}

	public void setFrom_currency_code(String from_currency_code) {
		this.from_currency_code = from_currency_code;
	}

	public String getFrom_currency_name() {
		return from_currency_name;
	}

	public void setFrom_currency_name(String from_currency_name) {
		this.from_currency_name = from_currency_name;
	}

	public String getTo_currency_code() {
		return to_currency_code;
	}

	public void setTo_currency_code(String to_currency_code) {
		this.to_currency_code = to_currency_code;
	}

	public String getTo_currency_name() {
		return to_currency_name;
	}

	public void setTo_currency_name(String to_currency_name) {
		this.to_currency_name = to_currency_name;
	}

	public String getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(String exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	public String getLast_refreshed() {
		return last_refreshed;
	}

	public void setLast_refreshed(String last_refreshed) {
		this.last_refreshed = last_refreshed;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	
	
	

}
