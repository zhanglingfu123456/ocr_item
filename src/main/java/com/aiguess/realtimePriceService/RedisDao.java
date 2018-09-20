package com.aiguess.realtimePriceService;

/**
 * @author 70492
 * 2018-04-17
 * 货币换算的redis的配置
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;  
import org.springframework.data.redis.core.ValueOperations;  
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;  
  








import java.util.Map;
import java.util.concurrent.TimeUnit;  
  
  
@Repository  
public class RedisDao {

    @Qualifier("redisExchangeDatabase")
    @Autowired
    private StringRedisTemplate template;  
  
    public  void setKey(String key,String value, int mins){  
        ValueOperations<String, String> ops = template.opsForValue();  
        ops.set(key,value, mins, TimeUnit.MINUTES);//1分钟过期  
    }  
    
    /**
     * 不设置超时时间
     * @param key
     * @return
     */
    public  void setKey(String key,String value){  
        ValueOperations<String, String> ops = template.opsForValue();  
        ops.set(key,value);//1分钟过期  
    }  
    
    public String getValue(String key){  
        ValueOperations<String, String> ops = this.template.opsForValue();  
        return ops.get(key);  
    }  
    
    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key,String field){
        HashOperations<String, Object, Object>  hash = this.template.opsForHash();
        return hash.get(key, field);
    }
    
    /**
     * 删除对应的value
     * @param key
     * @return 
     */
    public Boolean remove(final String key) {
        if (exists(key)) {
        	return this.template.delete(key);
        } else {
        	return false;
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return this.template.hasKey(key);
    }
    
    
    /**
     * 设置map
     * @param key
     * @param map
     */
    public void setMap(String key , Map<?, ?> map){
        this.template.opsForHash().putAll(key,map);
    }
    
    /**
     * 获取map
     */
    public Map<Object, Object> getMap(String key){
    	Map<Object, Object> resultMap= this.template.opsForHash().entries("map1");  
    	return resultMap;
    }
}  