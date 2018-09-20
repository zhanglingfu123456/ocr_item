package com.aiguess.realtimePriceService.entity.request;

import org.apache.commons.lang.ArrayUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:kaineng
 * @Description:
 * @Date:15:28 2018/8/6
 * @modified By:
 **/
public class FinFilterRequest {

    private String[] candidate;
    private int year;
    private int quarter;
    private String area;
    private String[] fields;
    private List<HashMap> filters;


    public String[] getCandidate() {
        return candidate;
    }

    public void setCandidate(String[] candidate) {
        this.candidate = candidate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public List<HashMap> getFilters() {
        return filters;
    }

    public void setFilters(List<HashMap> filters) {
        this.filters = filters;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("【candidate】:"+ArrayUtils.toString(candidate));
        result.append("【year】:"+year);
        result.append("【quarter】:"+quarter);
        result.append("【area】:"+area);
        result.append("【fields】:"+ArrayUtils.toString(fields));
        result.append("【filters】:"+fields);

        return result.toString();
    }
}