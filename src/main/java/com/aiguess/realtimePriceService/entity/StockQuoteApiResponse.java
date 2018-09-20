package com.aiguess.realtimePriceService.entity;

/**
 * api的结构体
 * @author kelen
 * @date 2018年4月12日 下午7:10:14
 */
public class StockQuoteApiResponse {
	
	private String stockCode;
    //private String stockName;
    private String currency;
    private String exchange;
    private double changePercent;
    private double trade;
    private double open;
    private double high;
    private double low;
    private double settlement;
    private double volume;
    private double turnOverRatio;
    private double amount;
    private double pe_ttm;
    private double pb;
    private double mktcap;
    
   // private double nmc;
    
    //增加一个标志  标志from  api  db
    private String from;
    
    //增加update_time
    private String update_time;
    
    


	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(double changePercent) {
		this.changePercent = changePercent;
	}
	public double getTrade() {
		return trade;
	}
	public void setTrade(double trade) {
		this.trade = trade;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getSettlement() {
		return settlement;
	}
	public void setSettlement(double settlement) {
		this.settlement = settlement;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getTurnOverRatio() {
		return turnOverRatio;
	}
	public void setTurnOverRatio(double turnOverRatio) {
		this.turnOverRatio = turnOverRatio;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getPe_ttm() {
		return pe_ttm;
	}
	public void setPe_ttm(double pe_ttm) {
		this.pe_ttm = pe_ttm;
	}
	public double getPb() {
		return pb;
	}
	public void setPb(double pb) {
		this.pb = pb;
	}
	public double getMktcap() {
		return mktcap;
	}
	public void setMktcap(double mktcap) {
		this.mktcap = mktcap;
	}
    
    
    
    

}
