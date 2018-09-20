package com.aiguess.common;

/*
 * api返回值的格式
 */
public class ApiResponse {
	
	private int code;
	
	private Object data;
	
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 构造方法
	 * @param code
	 * @param data
	 * @param msg
	 */
	public ApiResponse(int code, Object data, String msg) {
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

}
