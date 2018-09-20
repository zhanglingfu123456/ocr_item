package com.aiguess.realtimePriceService;

/**
 * OCR的API ，增值税专用
 * @Author:kaineng
 * @Description:
 * @Date:11:34 2018/9/19
 * @modified By:
 **/

import com.aiguess.common.ocr.AuthService;

import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;

import org.junit.Test;


import com.aiguess.Utils.Base64Util;
import com.aiguess.Utils.FileUtil;
import com.aiguess.Utils.HttpUtil;

import java.net.URLEncoder;

public class OcrApiTest {
    //@Value("${AppID}") //配置文件中的配置
    private String APP_ID = "14237927";
    //@Value("${AppKey}") //配置文件中的配置
    private String API_KEY = "P6djLW953tjQFZWwq7jbelGT";
    //@Value("${SecretKey}") //配置文件中的配置
    private String SECRET_KEY = "5P6nbjtgxqqR7hF74xDLbvvQp9YBIpa6";


    //sdk
    @Test
    public void test1() throws JSONException {
        String  token = AuthService.getAuth();

        System.err.println(token);

        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/vat_invoice";
        // 本地图片路径
        //String filePath = "#####本地文件路径#####";
//        String filePath = "F:\\ocr_item\\src\\test\\java\\com\\aiguess\\realtimePriceService\\56041379_right.jpg";
//        String filePath = "F:\\ocr_item\\src\\test\\java\\com\\aiguess\\realtimePriceService\\56041381_reverse.jpg";
        String filePath = "F:\\ocr_item\\src\\test\\java\\com\\aiguess\\realtimePriceService\\20310679.jpg";


        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = token;
            String result = HttpUtil.post(otherHost, accessToken, params);

            System.out.println(result);

            //发票号码
            JSONObject jsonObject = JSONObject.parseObject(result);

            JSONObject word = jsonObject.getJSONObject("words_result");
            String InvoiceNum = word.getString("InvoiceNum");
            System.out.println("InvoiceNum::"+InvoiceNum);
            System.out.println("InvoiceDate::"+word.getString("InvoiceDate"));
            System.out.println("销售方纳税识别号：SellerRegisterNum::"+word.getString("SellerRegisterNum"));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    



}