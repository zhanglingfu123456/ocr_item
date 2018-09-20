package com.aiguess.realtimePriceService.entity;

/**
 * alpha vantage 的接口返回的最小的item
 * @author kelen
 * @date 2018年4月12日 下午4:53:40
 *  {"1. open":"100.5750","2. high":"100.5800","3. low":"100.3900","4. close":"100.5200","5. volume":"45800"}
 */
public class AlphaVantageItem {
	
	/**
	 * 固定的key
	 */
	public static String OPEN = "1. open";
	
	public static String HIGH = "2. high";
	
	public static String LOW = "3. low";
	
	public static String CLOSE = "4. close";
	
	public static String VOLUME = "5. volume";
	
	private String open;
	
	private String high;
	
	private String low;
	
	private String close;
	
	private String volume;
	
	/**
	 * 自己家的一个remark
	 */
	private String remark;
	
	/*
	 * 自己家的，防止爬虫的没有更新
	 */
	private String previousClose;
	
	
	
	public String getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 新增加  update_time
	 * @return
	 */
	private String update_time;
	
	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String toString(){
		return this.open+" "+this.high+" "+this.low+" "+this.close+" "+this.volume +" "+this.update_time;
	}
	
	
	

}
