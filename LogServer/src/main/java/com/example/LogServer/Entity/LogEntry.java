package com.example.LogServer.Entity;

import java.util.Date;

public class LogEntry {
	
	private String message;
	private Date date;
	private String originService;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOriginService() {
		return originService;
	}
	public void setOriginService(String originService) {
		this.originService = originService;
	}
	
	
	

}
