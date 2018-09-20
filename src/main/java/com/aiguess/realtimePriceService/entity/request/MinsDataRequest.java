package com.aiguess.realtimePriceService.entity.request;


/**
 * 分钟行情的request
 * @author kelen
 * @date 2018年7月9日 下午6:26:51
 */
public class MinsDataRequest {

	/**WWWWWWWWW
	 * stock_code
	 * @return
	 */
	private String stock_code;
	

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("【stock_code】:"+stock_code );

		return str.toString();
	}

	public String getStock_code(){
		return this.stock_code;
	}
	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
}
