package com.aiguess.Utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author:kaineng
 * @Description: 对map进行排序输出
 * @Date:16:20 2018/8/10
 * @modified By:
 **/
public class SortedMapUtils {

    /**
     * 通过value进行排序，大道小
     * @return
     */
    public  static LinkedHashMap<String, BigDecimal>  sortByValueBigToSmall(Map<String, BigDecimal>  input_map) {
        List<Map.Entry<String, BigDecimal>> list = new ArrayList<>(input_map.entrySet());

//        Collections.sort(list,new Comparator<Map.Entry<String,BigDecimal>>() {
//            //升序排序
//            public int compare(Map.Entry<String, BigDecimal> o1, Map.Entry<String, BigDecimal> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });

        //升序排序 lambo
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 构造结果
        LinkedHashMap<String, BigDecimal> resultMap= new LinkedHashMap<>();
        for (Map.Entry<String, BigDecimal> e: list) {
            //System.out.println(e.getKey()+":"+e.getValue());
            resultMap.put(e.getKey(), e.getValue());
        }

        return resultMap;
    }

    /**
     * 通过value进行排序,小到大
     * @return
     */
    public  static LinkedHashMap<String, BigDecimal>  sortByValueSmallToBig(Map<String, BigDecimal>  input_map) {
        List<Map.Entry<String, BigDecimal>> list = new ArrayList<>(input_map.entrySet());

        //升序排序 lambo
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        // 构造结果
        LinkedHashMap<String, BigDecimal> resultMap= new LinkedHashMap<>();
        for (Map.Entry<String, BigDecimal> e: list) {
            //System.out.println(e.getKey()+":"+e.getValue());
            resultMap.put(e.getKey(), e.getValue());
        }

        return resultMap;
    }

    /**
     * 取到linkedHashMap的第一个last
     */
    public static Map.Entry<String, BigDecimal> getFirstElement(HashMap<String, BigDecimal>  map){
        Iterator<Map.Entry<String, BigDecimal>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, BigDecimal> entry = iterator.next();
            return  entry;
        }
        return null;
    }

    /**
     * 取到linkedHashMap的最后一个
     */
    public static Map.Entry<String, BigDecimal> getLastElement(HashMap<String, BigDecimal>  map){
        Field tail = null;
        try {
            tail = map.getClass().getDeclaredField("tail");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tail.setAccessible(true);
        try {
            return ((Map.Entry<String, BigDecimal>) tail.get(map)) ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;
    }



    /**
     * 负责查看打印的map，遍历
     * @param resultMap
     */
    public static void logForHashMap(Map resultMap){

        Iterator<String> ite = resultMap.keySet().iterator();
        //验证：
        // 跌幅最小
        while (ite.hasNext()) {
            String key = ite.next();
            System.err.println("key:"+key);
            System.err.println("value"+resultMap.get(key));
        }
    }



}
