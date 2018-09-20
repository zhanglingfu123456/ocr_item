package com.aiguess.realtimePriceService.entity;


/**
 * 实时股价请求的request
 * @author kelen
 * @date 2018年4月16日 上午10:19:29
 */
public class StockPriceApiRequest {
	
	private  String stock_code;

	public String getStock_code() {
		return stock_code;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}

}
