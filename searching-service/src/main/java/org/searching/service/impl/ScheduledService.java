package org.searching.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.quartz.JobDataMap;
import org.searching.util.DateUtil;
import org.searching.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Service
public class ScheduledService {
	@Value("${constants.housing-url}")
	private static String url;
	
	//@Scheduled(cron = "0 0/15 * * * *")
    public void scheduled() throws Exception{
    	//searching();
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
   
    public static String searching(JobDataMap dataMap) throws Exception{
    	String[] array = HttpClientUtil.getCookies("http://housing.icho.osaka-u.ac.jp/dormitory/search");
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	nameValuePairs.add(new BasicNameValuePair("start_date", dataMap.getString("start_date")));
    	nameValuePairs.add(new BasicNameValuePair("end_date", dataMap.getString("end_date")));
    	nameValuePairs.add(new BasicNameValuePair("check_suita", dataMap.getString("check_suita")));
    	nameValuePairs.add(new BasicNameValuePair("sex", dataMap.getString("sex")));
    	nameValuePairs.add(new BasicNameValuePair("number_of_people_capacity", dataMap.getString("number_of_people_capacity")));
    	nameValuePairs.add(new BasicNameValuePair("_token", array[1]));
    	String html = HttpClientUtil.getParams("http://housing.icho.osaka-u.ac.jp/dormitory/search",nameValuePairs,array[0]);
    	Document doc = Jsoup.parse(html);
    	String result = "有丶问题";
    	//html解析
    	if(doc!=null){
    		try {
    			Element pElement = doc.getElementsByClass("note").get(0);
            	result = pElement.html();
			} catch (Exception e) {
				SendSimpleMail.sendMail("宿舍查询情况 error" + "  " +  DateUtil.dateFmtToString(new Date()),e.getMessage());
			}
        	/*String jsonObj = JSONObject.toJSONString(dataMap);
        	log.info("=====>>>>>查询参数  {}",dataMap.toString());*/
        	log.info("=====>>>>>查询情况  {}",result);
    	}	
    	SendSimpleMail.sendMail("宿舍查询情况" + "  " +  DateUtil.dateFmtToString(new Date()),result);
    	return "";
    }
    
}
