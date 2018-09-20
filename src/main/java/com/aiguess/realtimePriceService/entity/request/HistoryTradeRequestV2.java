package com.aiguess.realtimePriceService.entity.request;

import org.apache.commons.lang.ArrayUtils;


/**
 * 历史行情的request
 * @author kelen
 * @date 2018年7月9日 下午6:26:51
 */
public class HistoryTradeRequestV2 {
	
	/**
	 * 数组
	 */
	private String stock_code;

	private String period;

	private String date_from;

	private String date_to;

	/**
	 * 是否复权  none 不复权  pre 前复权  post 后复权
	 * @return
	 */
	private String recovery;

	/**
	 * 是否复权的选项
	 * @return
	 * 雪球使用type字段，before、normal、after分别表示前复权、不复权、后复权，   所有日级别以上k线都默认前复权
	 *
	 */
	private String type;




	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("【stock_code】:"+stock_code);
		str.append("【period】:"+period);
		str.append("【type】:"+type);
		str.append("【date_from】:"+date_from);
		str.append("【date_to】:"+date_to);

		return str.toString();
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}

	public String getStock_code() {
		return this.stock_code;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getRecovery() {
		return recovery;
	}

	public void setRecovery(String recovery) {
		this.recovery = recovery;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
