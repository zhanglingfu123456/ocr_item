package com.aiguess.realtimePriceService.entity.request;


/**
 * 汇率api请求的request
 * @author kelen
 * @date 2018年4月18日 上午11:04:22
 */
public class ExchangeRatesRequest {
	
	private String from_currency;
	
	private String to_currency;

	public String getFrom_currency() {
		return from_currency;
	}

	public void setFrom_currency(String from_currency) {
		this.from_currency = from_currency;
	}

	public String getTo_currency() {
		return to_currency;
	}

	public void setTo_currency(String to_currency) {
		this.to_currency = to_currency;
	}
	
	

}
