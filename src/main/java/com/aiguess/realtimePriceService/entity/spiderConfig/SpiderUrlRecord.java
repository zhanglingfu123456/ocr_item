package com.aiguess.realtimePriceService.entity.spiderConfig;

import java.util.Date;

public class SpiderUrlRecord {
    private Long id;

    private String url;

    private String params;

    private String urlParamsMd5;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getUrlParamsMd5() {
        return urlParamsMd5;
    }

    public void setUrlParamsMd5(String urlParamsMd5) {
        this.urlParamsMd5 = urlParamsMd5 == null ? null : urlParamsMd5.trim();
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

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}