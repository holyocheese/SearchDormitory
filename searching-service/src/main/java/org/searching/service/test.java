package org.searching.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.searching.service.impl.SearchingQuatzJob;
import org.searching.util.DateUtil;
import org.searching.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class test {
	

	public static void main(String[] args) {
		/*String[] array = HttpClientUtil.getCookies("http://housing.icho.osaka-u.ac.jp/dormitory/search");
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	nameValuePairs.add(new BasicNameValuePair("start_date", "2019-03-01"));
    	nameValuePairs.add(new BasicNameValuePair("end_date", "2019-12-01"));
    	nameValuePairs.add(new BasicNameValuePair("check_suita", "1"));
    	nameValuePairs.add(new BasicNameValuePair("sex", "1"));
    	nameValuePairs.add(new BasicNameValuePair("number_of_people_capacity", "1"));
    	nameValuePairs.add(new BasicNameValuePair("_token", array[1]));
    	String html = HttpClientUtil.getParams("http://housing.icho.osaka-u.ac.jp/dormitory/search",nameValuePairs,array[0]);
    	Document doc = Jsoup.parse(html);
    	if(doc!=null){
    		Element pElement = doc.getElementsByClass("note").get(0);
        	String result = pElement.html();
        	System.out.println(result);
    	}*/
	}
	
	


}
