package com.aiguess.realtimePriceService.entity.request;

import org.apache.commons.lang.ArrayUtils;



/**
 * 历史行情的request
 * @author kelen
 * @date 2018年7月9日 下午6:26:51
 */
public class HistoryTradeRequest {
	
	/**
	 * 数组
	 */
	private String[] stock_code;

	private String period;
	
	private String date_from;
	
	private String date_to;
	
	/**
	 * 数组
	 */
	private String[] fields;
	
	private String recovery;

	public String[] getStock_code() {
		return stock_code;
	}

	public void setStock_code(String[] stock_code) {
		this.stock_code = stock_code;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public String getRecovery() {
		return recovery;
	}

	public void setRecovery(String recovery) {
		this.recovery = recovery;
	}
	
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("【stock_code】:"+ArrayUtils.toString(stock_code));
		str.append("【date_from】:"+date_from);
		str.append("【date_to】:"+date_to);
		
		str.append("【fields】:"+ArrayUtils.toString(fields));
		str.append("【recovery】:"+recovery);
		
		return str.toString();
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
}
