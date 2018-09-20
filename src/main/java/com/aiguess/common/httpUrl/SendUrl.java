package com.aiguess.common.httpUrl;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendUrl {

	private static final Logger logger = LoggerFactory.getLogger(SendUrl.class);
    
	
	/**
	 * 任务请求api的公共的
	 * @param port
	 * @param real_url
	 * @return
	 */
	public static String sendApi(String port,String real_url){
	    	
		    CloseableHttpClient httpclient = null;  
		    CloseableHttpResponse response = null;  
		    JSONObject jsonResult = null;
		    
		    httpclient = HttpClients.createDefault();
		    String url = "http://localhost:"+port+real_url;
		    logger.info("url是"+url);
		    // 创建httpget.      
		    HttpGet httpget = new HttpGet(url);    

		    RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(100000000).setConnectionRequestTimeout(100000000).setSocketTimeout(100000000).build();
		    
		    httpget.setConfig(requestConfig);

		    httpget.setHeader("refer", "http://www.baidu.com/s?tn=monline_5_dg&bs=httpclient4+MultiThreadedHttpConnectionManager");  

		    httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2"); 
		    
		    // 执行get请求.      
		    try {
				response = httpclient.execute(httpget);
				 // 获取响应实体      
			    HttpEntity entity = response.getEntity();    

			    // 打印响应状态      
			    //System.out.println(response.getStatusLine().getStatusCode());    
			    if (entity != null && response.getStatusLine().getStatusCode() == 200) {    
			    	 /**读取服务器返回过来的json字符串数据**/

			        String strResult = EntityUtils.toString(entity);

			        /**把json字符串转换成json对象**/

			        jsonResult = JSONObject.fromObject(strResult);
			        return jsonResult.toString();
			    }
			    
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		    
		    return "failed";
		   
		}
}
