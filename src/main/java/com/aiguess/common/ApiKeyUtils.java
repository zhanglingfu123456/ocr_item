package com.aiguess.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;



/**
 * 轮询拿到app的key
 * @author kelen
 * @date 2018年4月18日 下午2:28:39
 * 
 * apikey=MGG716O3N1KVYQ3H
## MCAF9B429I44328U
## ZPTR4JWGPMGU5YI0
## 8HIOTH1RMFBR6LJS
## 2IXHPM538RX5YHW7
 */
public class ApiKeyUtils {

	 
	 public static String  getKey(){
		 Random random = new Random();
		 
		 ApiKeyCacheMnager cache = ApiKeyCacheMnager.getInstance();  
	     Map<Integer, String> cacheMap = new ConcurrentHashMap<Integer, String>();  
	          
	     cacheMap = cache.getMapCache();  
		 int randomPos = random.nextInt(cacheMap.size());
		 System.err.println(cacheMap.get(randomPos));;
		 return cacheMap.get(randomPos);
	 }

}
