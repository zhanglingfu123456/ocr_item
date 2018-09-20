package com.aiguess.common;

import java.util.Map;  
import java.util.concurrent.ConcurrentHashMap;  
  
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
  
public class ApiKeyCacheMnager {  
  
    private final static Log log = LogFactory.getLog(ApiKeyCacheMnager.class);  
  
    private volatile long updateTime = 0L;// 更新缓存时记录的时间  
  
    private volatile boolean updateFlag = true;// 正在更新时的阀门，为false时表示当前没有更新缓存，为true时表示当前正在更新缓存  
  
    private volatile static ApiKeyCacheMnager mapCacheObject;// 缓存实例对象  
  
    private static Map<Integer, String> cacheMap = new ConcurrentHashMap<Integer, String>();// 缓存容器  
  
    private ApiKeyCacheMnager() {  
        this.LoadCache();// 加载缓存  
        updateTime = System.currentTimeMillis();// 缓存更新时间  
  
    }  
  
    /** 
     * 采用单例模式获取缓存对象实例 
     *  
     * @return 
     */  
    public static ApiKeyCacheMnager getInstance() {  
        if (null == mapCacheObject) {  
            synchronized (ApiKeyCacheMnager.class) {  
                if (null == mapCacheObject) {  
                    mapCacheObject = new ApiKeyCacheMnager();  
                }  
            }  
        }  
        return mapCacheObject;  
    }  
  
    /** 
     * 装载缓存 
     */  
    private void LoadCache() {  
  
        this.updateFlag = true;// 正在更新  
  
        /********** 数据处理，将数据放入cacheMap缓存中 **begin ******/   
        cacheMap.put(0, "MGG716O3N1KVYQ3H");
        cacheMap.put(1, "MCAF9B429I44328U");
        cacheMap.put(2, "8HIOTH1RMFBR6LJS");
        cacheMap.put(3, "2IXHPM538RX5YHW7");
        cacheMap.put(4, "E0GOBRBP15O5PKK2");
        cacheMap.put(5, "VBRCSIHES3L51SNF");
        

        /********** 数据处理，将数据放入cacheMap缓存中 ***end *******/  
  
        this.updateFlag = false;// 更新已完成  
  
    }  
  
    /** 
     * 返回缓存对象 
     *  
     * @return 
     */  
    public Map<Integer, String> getMapCache() {  
  
        long currentTime = System.currentTimeMillis();  
  
        if (this.updateFlag) {// 前缓存正在更新  
            log.info("cache is Instance .....");  
            return null;  
  
        }  
  
        if (this.IsTimeOut(currentTime)) {// 如果当前缓存正在更新或者缓存超出时限，需重新加载  
            synchronized (this) {  
                this.ReLoadCache();  
                this.updateTime = currentTime;  
            }  
        }  
  
        return this.cacheMap;  
    }  
  
    private boolean IsTimeOut(long currentTime) {  
  
        return ((currentTime - this.updateTime) > 1000000000);// 超过时限，超时  
    }  
  
    /** 
     * 获取缓存项大小 
     * @return 
     */  
    private int getCacheSize() {  
        return cacheMap.size();  
    }  
  
    /** 
     * 获取更新时间 
     * @return 
     */  
    private long getUpdateTime() {  
        return this.updateTime;  
    }  
  
    /** 
     * 获取更新标志 
     * @return 
     */  
    private boolean getUpdateFlag() {  
        return this.updateFlag;  
    }  
  
    /** 
     * 重新装载 
     */  
    private void ReLoadCache() {  
        this.cacheMap.clear();  
        this.LoadCache();  
    }  
  
}  