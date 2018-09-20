package com.aiguess.realtimePriceService.entity;

/**
 * IEX 
 * @author kelen
 * @date 2018年4月19日 下午9:08:16
 */
public class IexApiItem {
	
	private String open;
	
	private String high;
	
	private String low;
	
	private String close;
	
	private String volume;
	
	/**
	 * 新增加  update_time
	 * @return
	 */
	private String update_time;
	
	private String marketCap;
	
	private String previousClose;
	
	//市场
	private String exchange;
	
	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(String peRatio) {
		this.peRatio = peRatio;
	}

	private String peRatio;
	
	
	
	public String getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

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
