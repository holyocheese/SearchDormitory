package org.searching.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.searching.util.DateUtil;
import org.searching.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Service
public class ScheduledService {
	@Value("${constants.housing-url}")
	private static String url;
	
	//@Scheduled(cron = "0 0/15 * * * *")
    public void scheduled() throws Exception{
    	searching();
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
   
    public static String searching() throws Exception{
    	String[] array = HttpClientUtil.getCookies("http://housing.icho.osaka-u.ac.jp/dormitory/search");
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	nameValuePairs.add(new BasicNameValuePair("start_date", "2019-03-01"));
    	nameValuePairs.add(new BasicNameValuePair("end_date", "2019-12-01"));
    	nameValuePairs.add(new BasicNameValuePair("check_suita", "1"));
    	nameValuePairs.add(new BasicNameValuePair("sex", "1"));
    	nameValuePairs.add(new BasicNameValuePair("number_of_people_capacity", "1"));
    	nameValuePairs.add(new BasicNameValuePair("_token", array[1]));
    	String html = HttpClientUtil.getParams("http://housing.icho.osaka-u.ac.jp/dormitory/search",nameValuePairs,array[0]);
    	Document doc = Jsoup.parse(html);
    	String result = "有丶问题";
    	if(doc!=null){
    		Element pElement = doc.getElementsByClass("note").get(0);
        	result = pElement.html();
        	log.info("=====>>>>>查询情况  {}",result);
    	}	
    	SendSimpleMail.sendMail("宿舍查询情况" + "  " +  DateUtil.dateFmtToString(new Date()),result);
    	return "";
    }
    
}
