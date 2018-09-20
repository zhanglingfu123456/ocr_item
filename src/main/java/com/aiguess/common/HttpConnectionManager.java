package com.aiguess.common;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 第一 1.2 版本的链接线程池
 * @author kelen
 * @date 2018年4月25日 上午11:13:30
 * 
 * 04-25 采用开涛的方案，对照 time_schedule 的HttpConnectionManager 进行了配置升级
 * 暂时弃用
 */
//@Component
public class HttpConnectionManager {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
    PoolingHttpClientConnectionManager cm = null;
    
    //@PostConstruct
    public void init() {
    	logger.info("init  httpclient");
    	
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf)
                .register("httpUrl", new PlainConnectionSocketFactory())
                .build();
        cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(300);
        //每个路由的最大链接
        cm.setDefaultMaxPerRoute(200);
        SocketConfig defaultSocketConfig = SocketConfig.custom()
        		.setTcpNoDelay(true).build();
        cm.setDefaultSocketConfig(defaultSocketConfig);
      
    }

    public CloseableHttpClient getHttpClient() {   
    	//尝试下配置  超时时间
    	RequestConfig requestConfig = RequestConfig.custom()
    			.setConnectTimeout(2000)
    			.setConnectionRequestTimeout(2000)
    			.setSocketTimeout(2000)
    			.build();
    	 
        CloseableHttpClient httpClient = HttpClients.custom()
        		.setConnectionManager(cm)
        		.setDefaultRequestConfig(requestConfig)
        		.setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)
        		.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .build();     
        
        /*CloseableHttpClient httpClient = HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接*/
       
        //JVM关闭，需要关闭连接
        Runtime.getRuntime().addShutdownHook(new Thread(){
        	public void run(){
        		try {
					httpClient.close();
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
        	}
        });
        
        return httpClient;
    }
}