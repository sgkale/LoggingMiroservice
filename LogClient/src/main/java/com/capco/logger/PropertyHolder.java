package com.capco.logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertyHolder {

	@Value("${spring.application.name:unknown}")
	private String appName;

	@Value("${logging.remote.enable:false}")
	private boolean enableRemoteLogging;
	
	@Value("${logging.remote.logfilename:General}")
	private String logFileName;

	//@Value("${logging.remote.url:http://localhost:9000/api/v1/logs/addLog}")
	//private String loggingServiceURL;
	
	@Value("${logging.remote.application:http://localhost:9000/dummy}")
	private String applicationUrl;
	@Value("${logging.remote.audit:http://localhost:9000/dummy}")
	private String auditUrl;
	@Value("${logging.remote.transaction:http://localhost:9000/dummy}")
	private String transactionUrl;

	private static String staticAppName;
	private static boolean staticEnableRemoteLogging;	
	private static String staticApplicationUrl;
	private static String staticAuditUrl;
	private static String staticTransactionUrl;
	private static String staticLogFileName;

	//private static String staticLoggingServiceURL;
	
	@PostConstruct
	private void setStaticProperties() {
		System.out.println("setting properties");
		setStaticAppName(this.appName);
		setStaticEnableRemoteLogging(this.enableRemoteLogging);
		setStaticApplicationUrl(this.applicationUrl);
		setStaticAuditUrl(this.auditUrl);		
		setStaticTransactionUrl(this.transactionUrl);
		setStaticLogFileName(this.logFileName);
		
		//setStaticLoggingServiceURL(this.loggingServiceURL);
	}

	public String getLogFileName() {
		return logFileName;
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	public static String getStaticLogFileName() {
		return staticLogFileName;
	}

	public static void setStaticLogFileName(String staticLogFileName) {
		System.out.println(staticLogFileName);
		PropertyHolder.staticLogFileName = staticLogFileName;
	}

	public static void setStaticAppName(String name) {
		System.out.println(name);
		PropertyHolder.staticAppName = name;
	}

	public static void setStaticEnableRemoteLogging(boolean enable) {
		System.out.println(enable);
		PropertyHolder.staticEnableRemoteLogging = enable;
	}

	/*public static void setStaticLoggingServiceURL(String url) {
		System.out.println(url);
		PropertyHolder.staticLoggingServiceURL = url;
	}*/
	
	public static String getApplicationName() {
		return staticAppName;
	}

	public static boolean isRemoteLoggingEnabled() {
		return staticEnableRemoteLogging;
	}

	/*public static String getLoggingServiceURL() {
		return staticLoggingServiceURL;
	}*/

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public boolean isEnableRemoteLogging() {
		return enableRemoteLogging;
	}

	public void setEnableRemoteLogging(boolean enableRemoteLogging) {
		this.enableRemoteLogging = enableRemoteLogging;
	}

	public static String getStaticAppName() {
		return staticAppName;
	}

	public static boolean isStaticEnableRemoteLogging() {
		return staticEnableRemoteLogging;
	}

	public String getApplicationUrl() {
		return applicationUrl;
	}

	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	public String getAuditUrl() {
		return auditUrl;
	}

	public void setAuditUrl(String auditUrl) {
		this.auditUrl = auditUrl;
	}

	public String getTransactionUrl() {
		return transactionUrl;
	}

	public void setTransactionUrl(String transactionUrl) {
		this.transactionUrl = transactionUrl;
	}

	public static String getStaticApplicationUrl() {
		return staticApplicationUrl;
	}

	public static void setStaticApplicationUrl(String staticApplicationUrl) {
		PropertyHolder.staticApplicationUrl = staticApplicationUrl;
	}

	public static String getStaticAuditUrl() {
		return staticAuditUrl;
	}

	public static void setStaticAuditUrl(String staticAuditUrl) {
		PropertyHolder.staticAuditUrl = staticAuditUrl;
	}

	public static String getStaticTransactionUrl() {
		return staticTransactionUrl;
	}

	public static void setStaticTransactionUrl(String staticTransactionUrl) {
		PropertyHolder.staticTransactionUrl = staticTransactionUrl;
	}

	

}
