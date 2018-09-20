package com.aiguess.realtimePriceService.entity;

import java.util.Date;

public class RealtimeApiStockquoteUs {
    private String stockId;

    private String stockCode;

    private Double trade;

    private Double high;

    private Double low;

    private Double open;

    private Double settlement;

    private Double changePercent;

    private Double volume;

    private Double amount;

    private Double mktcap;

    private Double turnoverRatio;

    private Double peTtm;

    private Double pb;

    private String tickTime;

    private Long lastestUpdateTime;

    private Double high52week;

    private Double low52week;

    private Byte isValid;

    private Byte fromApiType;

    private Date updateTime;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public Double getTrade() {
        return trade;
    }

    public void setTrade(Double trade) {
        this.trade = trade;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getSettlement() {
        return settlement;
    }

    public void setSettlement(Double settlement) {
        this.settlement = settlement;
    }

    public Double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMktcap() {
        return mktcap;
    }

    public void setMktcap(Double mktcap) {
        this.mktcap = mktcap;
    }

    public Double getTurnoverRatio() {
        return turnoverRatio;
    }

    public void setTurnoverRatio(Double turnoverRatio) {
        this.turnoverRatio = turnoverRatio;
    }

    public Double getPeTtm() {
        return peTtm;
    }

    public void setPeTtm(Double peTtm) {
        this.peTtm = peTtm;
    }

    public Double getPb() {
        return pb;
    }

    public void setPb(Double pb) {
        this.pb = pb;
    }

    public String getTickTime() {
        return tickTime;
    }

    public void setTickTime(String tickTime) {
        this.tickTime = tickTime == null ? null : tickTime.trim();
    }

    public Long getLastestUpdateTime() {
        return lastestUpdateTime;
    }

    public void setLastestUpdateTime(Long lastestUpdateTime) {
        this.lastestUpdateTime = lastestUpdateTime;
    }

    public Double getHigh52week() {
        return high52week;
    }

    public void setHigh52week(Double high52week) {
        this.high52week = high52week;
    }

    public Double getLow52week() {
        return low52week;
    }

    public void setLow52week(Double low52week) {
        this.low52week = low52week;
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public Byte getFromApiType() {
        return fromApiType;
    }

    public void setFromApiType(Byte fromApiType) {
        this.fromApiType = fromApiType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}