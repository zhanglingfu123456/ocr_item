package com.aiguess.realtimePriceService.entity.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.sf.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 选股返回的结构体，为了去除null的字段
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbTrade0001Reponse implements Serializable {
    private String businessId;

    private String f001;

    private Date f002;

    private String f003;

    private String f004;

    private BigDecimal f005;

    private Float f006;

    private Float f007;

    private BigDecimal f008;

    private BigDecimal f009;

    private Float f010;

    private Float f011;

    private BigDecimal f012;

    private BigDecimal f013;

    private BigDecimal f014;

    private BigDecimal f015;

    private Long f016;

    private Long f017;

    private Float f018;

    private BigDecimal f019;

    private String f020;

    private BigDecimal f021;

    private BigDecimal f022;

    private BigDecimal f023;

    private Long f024;

    private Long f025;

    private Double f026;

    private Double f027;

    private Float f028;

    private Float f029;

    private Float f030;

    private Float f031;

    private Float f032;

    private Float f033;

    private Float f034;

    private Float f035;

    private String isValid;

    private Date updateTime;

    private String action;

    private byte[] id;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getF001() {
        return f001;
    }

    public void setF001(String f001) {
        this.f001 = f001 == null ? null : f001.trim();
    }

    public Date getF002() {
        return f002;
    }

    public void setF002(Date f002) {
        this.f002 = f002;
    }

    public String getF003() {
        return f003;
    }

    public void setF003(String f003) {
        this.f003 = f003 == null ? null : f003.trim();
    }

    public String getF004() {
        return f004;
    }

    public void setF004(String f004) {
        this.f004 = f004 == null ? null : f004.trim();
    }

    public BigDecimal getF005() {
        return f005;
    }

    public void setF005(BigDecimal f005) {
        this.f005 = f005;
    }

    public Float getF006() {
        return f006;
    }

    public void setF006(Float f006) {
        this.f006 = f006;
    }

    public Float getF007() {
        return f007;
    }

    public void setF007(Float f007) {
        this.f007 = f007;
    }

    public BigDecimal getF008() {
        return f008;
    }

    public void setF008(BigDecimal f008) {
        this.f008 = f008;
    }

    public BigDecimal getF009() {
        return f009;
    }

    public void setF009(BigDecimal f009) {
        this.f009 = f009;
    }

    public Float getF010() {
        return f010;
    }

    public void setF010(Float f010) {
        this.f010 = f010;
    }

    public Float getF011() {
        return f011;
    }

    public void setF011(Float f011) {
        this.f011 = f011;
    }

    public BigDecimal getF012() {
        return f012;
    }

    public void setF012(BigDecimal f012) {
        this.f012 = f012;
    }

    public BigDecimal getF013() {
        return f013;
    }

    public void setF013(BigDecimal f013) {
        this.f013 = f013;
    }

    public BigDecimal getF014() {
        return f014;
    }

    public void setF014(BigDecimal f014) {
        this.f014 = f014;
    }

    public BigDecimal getF015() {
        return f015;
    }

    public void setF015(BigDecimal f015) {
        this.f015 = f015;
    }

    public Long getF016() {
        return f016;
    }

    public void setF016(Long f016) {
        this.f016 = f016;
    }

    public Long getF017() {
        return f017;
    }

    public void setF017(Long f017) {
        this.f017 = f017;
    }

    public Float getF018() {
        return f018;
    }

    public void setF018(Float f018) {
        this.f018 = f018;
    }

    public BigDecimal getF019() {
        return f019;
    }

    public void setF019(BigDecimal f019) {
        this.f019 = f019;
    }

    public String getF020() {
        return f020;
    }

    public void setF020(String f020) {
        this.f020 = f020 == null ? null : f020.trim();
    }

    public BigDecimal getF021() {
        return f021;
    }

    public void setF021(BigDecimal f021) {
        this.f021 = f021;
    }

    public BigDecimal getF022() {
        return f022;
    }

    public void setF022(BigDecimal f022) {
        this.f022 = f022;
    }

    public BigDecimal getF023() {
        return f023;
    }

    public void setF023(BigDecimal f023) {
        this.f023 = f023;
    }

    public Long getF024() {
        return f024;
    }

    public void setF024(Long f024) {
        this.f024 = f024;
    }

    public Long getF025() {
        return f025;
    }

    public void setF025(Long f025) {
        this.f025 = f025;
    }

    public Double getF026() {
        return f026;
    }

    public void setF026(Double f026) {
        this.f026 = f026;
    }

    public Double getF027() {
        return f027;
    }

    public void setF027(Double f027) {
        this.f027 = f027;
    }

    public Float getF028() {
        return f028;
    }

    public void setF028(Float f028) {
        this.f028 = f028;
    }

    public Float getF029() {
        return f029;
    }

    public void setF029(Float f029) {
        this.f029 = f029;
    }

    public Float getF030() {
        return f030;
    }

    public void setF030(Float f030) {
        this.f030 = f030;
    }

    public Float getF031() {
        return f031;
    }

    public void setF031(Float f031) {
        this.f031 = f031;
    }

    public Float getF032() {
        return f032;
    }

    public void setF032(Float f032) {
        this.f032 = f032;
    }

    public Float getF033() {
        return f033;
    }

    public void setF033(Float f033) {
        this.f033 = f033;
    }

    public Float getF034() {
        return f034;
    }

    public void setF034(Float f034) {
        this.f034 = f034;
    }

    public Float getF035() {
        return f035;
    }

    public void setF035(Float f035) {
        this.f035 = f035;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public byte[] getId() {
        return id;
    }

    public void setId(byte[] id) {
        this.id = id;
    }

    //toString
    public String  toString(){

        return JSONObject.fromObject(this).toString() ;
    }
}