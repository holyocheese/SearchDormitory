package org.searching.util;

import java.io.Serializable;

//Rest封装
public class MsgVo<E> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5932814721510280480L;
	private int status;
	private String message;
	private E data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	
	
	
}
