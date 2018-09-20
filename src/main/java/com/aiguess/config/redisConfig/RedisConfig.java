package com.aiguess.config.redisConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


/**
 * redis 的config， redis2
 */
@Configuration
public class RedisConfig {

    @Bean(name = "redisSpiderDatabase")
    public StringRedisTemplate  redisTemplate(
            @Value("${spring.redis2.host}")String hostName,
            @Value("${spring.redis2.port}")int port,
            @Value("${spring.redis2.password}")String password,
            @Value("${spring.redis.pool.max-idle}")int maxIdle,
            @Value("${spring.redis.pool.max-active}")int maxTotal,
            @Value("${spring.redis2.database}")int index,
            @Value("${spring.redis.timeout}")long maxWaitMillis) {
        StringRedisTemplate temple = new StringRedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password,
                maxIdle, maxTotal, index, maxWaitMillis));

        //serializer add  就很清晰
        temple.setKeySerializer(new StringRedisSerializer());
        temple.setValueSerializer(new StringRedisSerializer());

        return temple;
    }

    @Bean(name = "redisObjectTradeDatabase")
    public RedisTemplate<String, Object> redisObjectTemplate(
            @Value("${spring.redis2.host}")String hostName,
            @Value("${spring.redis2.port}")int port,
            @Value("${spring.redis2.password}")String password,
            @Value("${spring.redis.pool.max-idle}")int maxIdle,
            @Value("${spring.redis.pool.max-active}")int maxTotal,
            @Value("${spring.redis2.database}")int index,
            @Value("${spring.redis.timeout}")long maxWaitMillis) {
        RedisTemplate temple = new RedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password,
                maxIdle, maxTotal, index, maxWaitMillis));
        //尝试一下这个
        //temple.setKeySerializer(new StringRedisSerializer());
        return temple;
    }

    /*@Bean(name = "redisExchangeDatabase")
    public StringRedisTemplate  redisExchangeTemplate(
            @Value("${spring.redis.host}")String hostName,
            @Value("${spring.redis.port}")int port,
            @Value("${spring.redis.password}")String password,
            @Value("${spring.redis.pool.max-idle}")int maxIdle,
            @Value("${spring.redis.pool.max-active}")int maxTotal,
            @Value("${spring.redis.database}")int index,
            @Value("${spring.redis.timeout}")long maxWaitMillis) {
        StringRedisTemplate temple = new StringRedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, port, password,
                maxIdle, maxTotal, index, maxWaitMillis));
        return temple;
    }*/



    public RedisConnectionFactory connectionFactory(
            String hostName, int port, String password, int maxIdle,int maxTotal, int index, long maxWaitMillis) {
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        jedis.setHostName(hostName);
        jedis.setPort(port);
        jedis.setPassword(password);
        jedis.setDatabase(index);
        jedis.setPoolConfig(this.poolCofig(maxIdle, maxTotal, maxWaitMillis));
        // 初始化连接pool
        jedis.afterPropertiesSet();
        RedisConnectionFactory factory = jedis;
        return factory;
    }

    public JedisPoolConfig poolCofig(int maxIdle, int maxTotal, long maxWaitMillis) {
        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWaitMillis);
        poolCofig.setTestOnBorrow(false);
        return poolCofig;
    }
}