package org.searching.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



/**
 * HTTPClient工具类
 * @author liufei
 *
 */
public class HttpClientUtil {

	private static final Logger logger= LoggerFactory.getLogger(HttpClientUtil.class);
	
	private static String cookieB = "_ga=GA1.3.475955086.1537885519;"
			+ "__utmz=223199365.1545622349.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); "
			+ "_gid=GA1.3.59849034.1545622606; "
			+ "__utma=223199365.475955086.1537885519.1545622349.1545633725.3;";
	
	
    /**
     * 测试
     * @param arg 参数数组
     * @throws Exception 异常抛出
     */
    public static void main(String arg[]) throws Exception {
        String url = "test.com";
        JSONObject params = new JSONObject();
        params.put("SRC_STM_CODE", "wsf");
        params.put("TENANT_ID", "123");
        params.put("NM", "张三");
        params.put("BRTH_DT", "1983-01-20");
        params.put("GND_CODE", "1");
        JSONArray params2 = new JSONArray();
        JSONObject param3 = new JSONObject();
        param3.put("DOC_TP_CODE", "10100");
        param3.put("DOC_NBR", "100200198301202210");
        param3.put("DOC_CUST_NM", "test");
        params2.add(param3);
        params.put("DOCS", params2);
    }

    /**
     * post请求
     * 
     * @param url 请求的第三方地址
     * @param json 需要传的参数
     * @return JSONObject类型对象
     */
    public static String getParams(String url,List<NameValuePair> nameValuePairs,String cookies) {
	    // 获取连接客户端工具
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	 
	    String entityStr = null;
	    CloseableHttpResponse response = null;
	 
	    try {
	        URIBuilder uriBuilder = new URIBuilder(url);
	        uriBuilder.setParameters(nameValuePairs);
	 
	        // 根据带参数的URI对象构建GET请求对象
	        HttpPost httpPost = new HttpPost(uriBuilder.build());
	        
	        /* 
	         * 添加请求头信息
	         */
	        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
	        httpPost.addHeader("Cookie",cookieB+cookies);
	        // 执行请求
	        response = httpClient.execute(httpPost);
	        // 获得响应的实体对象
	        HttpEntity entity = response.getEntity();
	        // 使用Apache提供的工具类进行转换成字符串
	        entityStr = EntityUtils.toString(entity, "UTF-8");
	    } catch (ClientProtocolException e) {
	        System.err.println("Http协议出现问题");
	        e.printStackTrace();
	    } catch (URISyntaxException e) {
	        System.err.println("URI解析异常");
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.err.println("IO异常");
	        e.printStackTrace();
	    } finally {
	        // 释放连接
	        if (null != response) {
	            try {
	                response.close();
	                httpClient.close();
	            } catch (IOException e) {
	                System.err.println("释放连接出错");
	                e.printStackTrace();
	            }
	        }
	    }
	    // 返回
	    return entityStr;
	}
    
    
    /**
     * post请求
     * 
     * @param url 请求的第三方地址
     * @param json 需要传的参数
     * @return JSONObject类型对象
     */
    public static String[] getCookies(String url) {
	    // 获取连接客户端工具
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	 
	    CloseableHttpResponse response = null;
	    String[] result = new String[2];
	    try {
	        URIBuilder uriBuilder = new URIBuilder(url);
	 
	        // 根据带参数的URI对象构建GET请求对象
	        HttpGet httpPost = new HttpGet(uriBuilder.build());
	 
	        /* 
	         * 添加请求头信息
	         */
	        httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
	        //httpPost.addHeader("Cookie","_ga=GA1.3.475955086.1537885519; __utmz=223199365.1545622349.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); _gid=GA1.3.59849034.1545622606; __utma=223199365.475955086.1537885519.1545622349.1545633725.3; XSRF-TOKEN=eyJpdiI6IjM2eE5DU0hZZWNMbnFwMVU5OVE1TGc9PSIsInZhbHVlIjoiS0diRDN0a3JWT25SVFdUajRRSHVvWjNHN3diaXNZa1hrVmQySFgzSGthYXF5T2hoQmFGajNJVytOZXJ6ODhmOUt3VWhyVUtmVTNldEVPV0VcL1JtcmpnPT0iLCJtYWMiOiI2OTgyOWY5ZTAxMmE3YWUzOWY2ZmRiOGY5OGEyZjRiZjE0NzcyZGEzZmQ1NWIxNWFlOTJhNzE2NTgzNGI2NTEwIn0%3D; laravel_session=eyJpdiI6InFDbzU0b3EwZlFsQ0VtaHN0SVN3M0E9PSIsInZhbHVlIjoiaG9VUjR6MTdnQnFxdnp5S3JXM3J5Ym9FdzAyWmppTGkzaU9KTVN3a2RJb0cxUURjR1wvQ25mVFQ3dklFTGJ1amltalhmNjk0QUFGOHA1cEpaSURGRnNRPT0iLCJtYWMiOiI4ZTc0MjAzYmExNjViNTUxMTQ2ODkzOTZkMWY0NTMzMmNmMTk1ZWM1ZmZjY2ZmOTYyNTlkOGRlZmU1MDQ3MDljIn0%3D");
	        // 执行请求
	        String tokenStr = "";
	        response = httpClient.execute(httpPost);
	        Header[] headers = response.getHeaders("Set-Cookie");
	        if(headers!=null&headers.length==2){
	        	Header xheader = headers[0];
	        	String xtoken = xheader.getValue();
	        	xtoken = xtoken.substring(0,xtoken.indexOf(";")+1);
	        	tokenStr += xtoken;
	        	xheader = headers[1];
	        	String sessiontoken = xheader.getValue();
	        	sessiontoken = sessiontoken.substring(0,sessiontoken.indexOf(";")+1);
	        	tokenStr += sessiontoken;
	        }
	        result[0] = tokenStr;
	        // 获得响应的实体对象
	        HttpEntity entity = response.getEntity();
	        // 使用Apache提供的工具类进行转换成字符串
	        String entityStr = EntityUtils.toString(entity, "UTF-8");
	        Document doc = Jsoup.parse(entityStr);
	        Element pElement = doc.getElementsByAttributeValue("name","_token").get(0);
	        String token = pElement.attr("value");
        	result[1] = token;
	    } catch (ClientProtocolException e) {
	        System.err.println("Http协议出现问题");
	        e.printStackTrace();
	    } catch (URISyntaxException e) {
	        System.err.println("URI解析异常");
	        e.printStackTrace();
	    } catch (IOException e) {
	        System.err.println("IO异常");
	        e.printStackTrace();
	    } finally {
	        // 释放连接
	        if (null != response) {
	            try {
	                response.close();
	                httpClient.close();
	            } catch (IOException e) {
	                System.err.println("释放连接出错");
	                e.printStackTrace();
	            }
	        }
	    }
	    // 返回
	    return result;
	}
}