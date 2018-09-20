package com.aiguess.realtimePriceService.entity.spiderConfig;

import java.util.Date;

public class SpiderSourceFileCategory {
    private Integer id;

    private String categoryName;

    private Integer parentId;

    private String allNodes;

    private String fileCategoryRule;

    private String fileStore;

    private String comment;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAllNodes() {
        return allNodes;
    }

    public void setAllNodes(String allNodes) {
        this.allNodes = allNodes == null ? null : allNodes.trim();
    }

    public String getFileCategoryRule() {
        return fileCategoryRule;
    }

    public void setFileCategoryRule(String fileCategoryRule) {
        this.fileCategoryRule = fileCategoryRule == null ? null : fileCategoryRule.trim();
    }

    public String getFileStore() {
        return fileStore;
    }

    public void setFileStore(String fileStore) {
        this.fileStore = fileStore == null ? null : fileStore.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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