package com.aiguess.Utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;



/**
 * 获取两个时间的间隔
 * @author kelen
 * @date 2018年7月10日 上午10:41:59
 */
public class BetweeenDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> betweenDate = getBetweenDate("2017-09-03", "2017-10-06");
		
		for (String date : betweenDate) {
			System.err.println(date);;
		}

	}
	
	/*
	   * 获取两个日期间隔的所有日期 
	     * @param start 格式必须为'2018-01-25' 
	     * @param end 格式必须为'2018-01-25' 
	     * @return 
	     */  
	    public static List<String> getBetweenDate(String start, String end){  
	        List<String> list = new ArrayList<>();  
	        LocalDate startDate = LocalDate.parse(start);  
	        LocalDate endDate = LocalDate.parse(end);  
	          
	        long distance = ChronoUnit.DAYS.between(startDate, endDate);  
	        if (distance < 1) {  
	            return list;  
	        }  
	        Stream.iterate(startDate, d -> {  
	            return d.plusDays(1);  
	        }).limit(distance + 1).forEach(f -> {
	        	//排除周末
	        	if (!WeekendMethod(f.toString())) {
					list.add(f.toString());
				}

	        });  
	        return list;  
	    }


	/**
	 * 是否周末
	 * @param date
	 * @return
	 */
	public static boolean WeekendMethod(String date) {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String Date = date;  //传入的date格式是yyyy-MM-dd
		java.util.Date bdate=null;
		try {
			bdate = format1.parse(Date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(bdate);
		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
		{
			//System.out.println("是周末");
			return true;
		}
		else
			//System.out.println("不是周末！");
			return false;
	}

}
