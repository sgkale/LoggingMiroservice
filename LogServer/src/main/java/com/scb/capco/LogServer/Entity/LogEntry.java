package com.scb.capco.LogServer.Entity;

import java.util.Date;

import ch.qos.logback.classic.Level;


public class LogEntry {
	
	private String message;
	private Date date;
	private String originService;
	private Level level;
	private String logFileName;
	
	public String getLogFileName() {
		return logFileName;
	}
	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}
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
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
