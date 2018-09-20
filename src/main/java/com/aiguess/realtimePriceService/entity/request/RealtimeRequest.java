package com.aiguess.realtimePriceService.entity.request;


import org.apache.commons.lang.ArrayUtils;

/**
 * 实时的的request
 * @author kelen
 * @date 2018年7月9日 下午6:26:51
 */
public class RealtimeRequest {

	/**WWWWWWWWW
	 * stock_code
	 * @return
	 */
	private String[] stock;
	

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("【stock】:"+ArrayUtils.toString(stock));

		return str.toString();
	}

	public String[] getStock() {
		return this.stock ;
	}

	public void setStock(String[] stock) {
		this.stock = stock;
	}
}
