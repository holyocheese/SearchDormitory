package org.searching.service.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchOsakaRequest extends CronRequest{

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	private String checkSuita;
	
	private String sex;
	
	private String number;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCheckSuita() {
		return checkSuita;
	}

	public void setCheckSuita(String checkSuita) {
		this.checkSuita = checkSuita;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
