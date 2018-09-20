package com.aiguess.realtimePriceService;

/**
 * @Author:kaineng
 * @Description:
 * @Date:11:34 2018/9/10
 * @modified By:
 *
 * OCR 的SDK，通用文字和通用票据
 **/

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;



public class OcrImageTest {
    //@Value("${AppID}") //配置文件中的配置
    private String APP_ID = "14237927";
    //@Value("${AppKey}") //配置文件中的配置
    private String API_KEY = "P6djLW953tjQFZWwq7jbelGT";
    //@Value("${SecretKey}") //配置文件中的配置
    private String SECRET_KEY = "5P6nbjtgxqqR7hF74xDLbvvQp9YBIpa6";


    //sdk
    @Test
    public void test1() throws JSONException {


            // 初始化一个AipOcr
            AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(20000);
            client.setSocketTimeoutInMillis(600000);

            // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
            //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
           // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

            // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
            // 也可以直接通过jvm启动参数设置此环境变量
            //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

            // 1.调用接口  通用文字
//            String path = "F:\\ocr_item\\src\\test\\java\\com\\aiguess\\realtimePriceService\\56041380.jpg";
//            JSONObject res = client.basicGeneral(path, new HashMap<String, String>());

            //2.通用票据
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("recognize_granularity", "big");
        options.put("probability", "true");
        options.put("accuracy", "normal");
        options.put("detect_direction", "true");

        String image = "F:\\ocr_item\\src\\test\\java\\com\\aiguess\\realtimePriceService\\56041380.jpg";
        JSONObject res = client.receipt(image, options);
        System.out.println(res.toString(2));






        System.out.println(res.toString(2));

    }






}