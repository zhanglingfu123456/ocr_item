package com.aiguess.common;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  1.3 版本的，最新的尝试
 * 单例的httpClient
 * @author kelen
 * @date 2018年4月25日 上午11:10:08
 */
public class CustomerHttpClient {
	private final static Logger logger = LoggerFactory.getLogger(CustomerHttpClient.class);  
	
	private static CloseableHttpClient httpClient;
	   
	
	public static synchronized CloseableHttpClient getHttpClient(){
		logger.info("get  httpClient");
		if (httpClient == null) {
			
			logger.info("new  httpClient");
			PoolingHttpClientConnectionManager cm = null;
			LayeredConnectionSocketFactory sslsf = null;
			javax.net.ssl.SSLContext sslContext =null;
			try {
				//最初的
				//sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
				
				//引入https不验证
				try {
					sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {  
					    // 默认信任所有证书  
					    public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {  
					        return true;  
					    }  
					}).build();
				} catch (KeyManagementException | KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	            // AllowAllHostnameVerifier: 这种方式不对主机名进行验证，验证功能被关闭，是个空操作(域名验证)  
				sslsf = new SSLConnectionSocketFactory(sslContext,  
	                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
				
				//引入新的结束
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create()
					.register("https", sslsf)
					.register("httpUrl", new PlainConnectionSocketFactory())
					.build();
			cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			cm.setMaxTotal(300);
			// 每个路由的最大链接
			cm.setDefaultMaxPerRoute(200);
			SocketConfig defaultSocketConfig = SocketConfig.custom()
					.setTcpNoDelay(true).build();
			cm.setDefaultSocketConfig(defaultSocketConfig);
			// 尝试下配置 超时时间
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(2000).setConnectionRequestTimeout(2000)
					.setSocketTimeout(2000).build();

			httpClient = HttpClients
					.custom()
					.setConnectionManager(cm)
					.setDefaultRequestConfig(requestConfig)
					.setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)
					.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
					.build();

			/*
			 * CloseableHttpClient httpClient =
			 * HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接
			 */

			// JVM关闭，需要关闭连接
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					try {
						httpClient.close();
						logger.info("close  httpClient");
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			});

		}
		
		return httpClient;
	}
	   
   
}