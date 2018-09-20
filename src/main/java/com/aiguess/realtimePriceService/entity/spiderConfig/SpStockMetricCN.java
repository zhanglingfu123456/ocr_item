package com.aiguess.realtimePriceService.entity.spiderConfig;

import java.util.Date;

public class SpStockMetricCN {
    private Integer id;

    private String stockId;

    private String stockCode;

    private Integer rowIndex;

    private String rowName;

    private Short year;

    private Byte quarter;

    private String rquarter;

    private String cash;

    private String unit;

    private Date rdateBegin;

    private Date rdateEnd;

    private Double value;

    private Date updateTime;

    private String spiderSource;

    private Integer metricId;

    private Integer sheetType;

    private String uniqueKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName == null ? null : rowName.trim();
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Byte getQuarter() {
        return quarter;
    }

    public void setQuarter(Byte quarter) {
        this.quarter = quarter;
    }

    public String getRquarter() {
        return rquarter;
    }

    public void setRquarter(String rquarter) {
        this.rquarter = rquarter == null ? null : rquarter.trim();
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash == null ? null : cash.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getRdateBegin() {
        return rdateBegin;
    }

    public void setRdateBegin(Date rdateBegin) {
        this.rdateBegin = rdateBegin;
    }

    public Date getRdateEnd() {
        return rdateEnd;
    }

    public void setRdateEnd(Date rdateEnd) {
        this.rdateEnd = rdateEnd;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSpiderSource() {
        return spiderSource;
    }

    public void setSpiderSource(String spiderSource) {
        this.spiderSource = spiderSource == null ? null : spiderSource.trim();
    }

    public Integer getMetricId() {
        return metricId;
    }

    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
    }

    public Integer getSheetType() {
        return sheetType;
    }

    public void setSheetType(Integer sheetType) {
        this.sheetType = sheetType;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
    }
}