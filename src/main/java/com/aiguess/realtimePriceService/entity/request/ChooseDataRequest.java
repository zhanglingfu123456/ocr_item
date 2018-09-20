package com.aiguess.realtimePriceService.entity.request;


import org.apache.commons.lang.ArrayUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;


/**
 * 股票筛选的request
 */
public class ChooseDataRequest {


	/**
	 * 备选的股票code
	 */
	private String[] candidate;

	/**
	 * dateFrom
	 * @return
	 */
	private String dateFrom;

	private String dateTo;

	private String[] fields;

	private List<HashMap> filters;


	public String[] getCandidate() {
		return candidate;
	}

	public void setCandidate(String[] candidate) {
		this.candidate = candidate;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("【candidate】:"+ArrayUtils.toString(candidate));
		str.append("【dateFrom】:"+dateFrom);
		str.append("【dateTo】:"+dateTo);
		str.append("【filter】:"+filters);
		str.append("【fields】:"+ArrayUtils.toString(fields));

		return str.toString();
	}

	/**
	 * 现在是最早的数据2010-01-01
	 * @return
	 */
	public String getDateFrom() {
		try {
			if ( (new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom)).getTime() <= (new SimpleDateFormat("yyyy-MM-dd").parse("2010-01-04")).getTime() ) {
				dateFrom = "2010-01-04";
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return  dateFrom;
		}
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	public  List<HashMap> getFilters() {
		return filters;
	}

	public void setFilters( List<HashMap> filters) {
		this.filters = filters;
	}




}

class Filter{

	public Filter(String field,String operation, List parmas){
		this.field = field;
		this.operation = operation;
		this.param = parmas;

	}


	private String field;

	private String operation;

	private List param;


	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List getParam() {
		return param;
	}

	public void setParam(List param) {
		this.param = param;
	}
}
