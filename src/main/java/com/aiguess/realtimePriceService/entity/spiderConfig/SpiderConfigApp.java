package com.aiguess.realtimePriceService.entity.spiderConfig;

import java.util.Date;

public class SpiderConfigApp {
    private Integer id;

    private String appName;

    private Integer categoryId;

    private Byte businessPriority;

    private Byte priority;

    private Integer parentListAppId;

    private String domain;

    private Byte modelType;

    private Byte selectorType;

    private String scanUrl;

    private String params;

    private String macroValues;

    private String listSelector;

    private String scheduleRule;

    private String headerConfig;

    private String otherConfig;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    private Byte isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Byte getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Byte businessPriority) {
        this.businessPriority = businessPriority;
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public Integer getParentListAppId() {
        return parentListAppId;
    }

    public void setParentListAppId(Integer parentListAppId) {
        this.parentListAppId = parentListAppId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public Byte getModelType() {
        return modelType;
    }

    public void setModelType(Byte modelType) {
        this.modelType = modelType;
    }

    public Byte getSelectorType() {
        return selectorType;
    }

    public void setSelectorType(Byte selectorType) {
        this.selectorType = selectorType;
    }

    public String getScanUrl() {
        return scanUrl;
    }

    public void setScanUrl(String scanUrl) {
        this.scanUrl = scanUrl == null ? null : scanUrl.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getMacroValues() {
        return macroValues;
    }

    public void setMacroValues(String macroValues) {
        this.macroValues = macroValues == null ? null : macroValues.trim();
    }

    public String getListSelector() {
        return listSelector;
    }

    public void setListSelector(String listSelector) {
        this.listSelector = listSelector == null ? null : listSelector.trim();
    }

    public String getScheduleRule() {
        return scheduleRule;
    }

    public void setScheduleRule(String scheduleRule) {
        this.scheduleRule = scheduleRule == null ? null : scheduleRule.trim();
    }

    public String getHeaderConfig() {
        return headerConfig;
    }

    public void setHeaderConfig(String headerConfig) {
        this.headerConfig = headerConfig == null ? null : headerConfig.trim();
    }

    public String getOtherConfig() {
        return otherConfig;
    }

    public void setOtherConfig(String otherConfig) {
        this.otherConfig = otherConfig == null ? null : otherConfig.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}