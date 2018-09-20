package com.aiguess.realtimePriceService.entity.response;

/**
 * 返回结构体定义
 * @Author:kaineng
 * @Description:
 * @Date:19:22 2018/9/11
 * @modified By:
 **/
public class ApiResponse {

    private int code;

    private String msg;

    private Object data;

    ApiResponse(int code, Object data, String msg){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
