package com.aiguess.Utils;

/**
 * @Author:kaineng
 * @Description:
 * @Date:16:36 2018/8/7
 * @modified By:kelen
 * 得到时间段的月和日
 *
 **/
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateAndTimeUtil {


    /**
     * 根据 年、月 获取对应的月份 的 天数
     */
    public static int getDaysByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
    //获取指定日期之间的所有年月
    @SuppressWarnings("unused")
    public static HashMap<String ,List<String>> getMonthBetween(String minDate, String maxDate) throws ParseException {

        HashMap<String ,List<String>> result = new HashMap<>();

        ArrayList<String> data_month = new ArrayList<String>();
        ArrayList<String> data_days= new ArrayList<String>();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {

            //同一个月直接结束 以前的bug
            if (sdf.parse(minDate).equals(sdf.parse(maxDate))) {
                data_days.addAll(BetweeenDate.getBetweenDate(minDate, maxDate));
                break;
            }

            //判断是不是最后一天
            if (sdf.format(curr.getTime()).equals(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(minDate))) && !isFirstDayOfMonth(new SimpleDateFormat("yyyy-MM-dd").parse(minDate))) {
                curr.add(Calendar.MONTH, 1);
                //这个是天，取到月底的天
                String arr[] = minDate.split("-");
                List<String> list = BetweeenDate.getBetweenDate(minDate, getLastDayOfMonth(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]))  );
                data_days.addAll(list);

            }else if (sdf.format(curr.getTime()).equals(sdf.format(new SimpleDateFormat("yyyy-MM-dd").parse(maxDate))) && !isLastDayOfMonth(new SimpleDateFormat("yyyy-MM-dd").parse(maxDate))) {
                curr.add(Calendar.MONTH, 1);

                //这个是天，去月初的
                String arr[] = maxDate.split("-");

                List<String> list = BetweeenDate.getBetweenDate( getFisrtDayOfMonth(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])) , maxDate );
                data_days.addAll(list);
            }else {
                //这里是
//                data_month.add(sdf.format(curr.getTime()));
                data_month.add( new SimpleDateFormat("yyyyMM").format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }

        }

        result.put("month", data_month);

        result.put("days", data_days);

        return result;
    }


    //demo
    public static void main(String[] args) throws ParseException {
        HashMap<String, List<String>> date = getMonthBetween("2018-05-07","2018-08-11");
        //月数目  month
        List<String> list= date.get("month");
        for (String string : list) {
            System.out.println(string);
        }

        //天数 dyas
        List<String> list_days = date.get("days");
        for (String string : list_days) {
            System.out.println(string);
        }

        System.err.println("is first "+isLastDayOfMonth(new SimpleDateFormat("yyyy-MM-dd").parse("2017-02-27")));


        System.err.println(getLastDayOfMonth(Integer.parseInt("2018-03-05".split("-")[0]), Integer.parseInt("2018-03-05".split("-")[1])));
    }




    /**
     * 判断该日期是否是该月的第一天
     *
     * @param date
     *            需要判断的日期
     * @return
     */
    public static boolean isFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONTH));
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;

    }

    /**
     * 判断该日期是否是该月的最后一天
     *
     * @param date
     *            需要判断的日期
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某月的最后一天
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     * @throws
     */
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    /**
     * first Day
     * @param year
     * @param month
     * @return
     */
    public static String getFisrtDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());

        return firstDayOfMonth;
    }




}