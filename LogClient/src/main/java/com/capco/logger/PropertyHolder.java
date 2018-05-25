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

	@Value("${logging.remote.enable:true}")
	private boolean enableRemoteLogging;

	@Value("${logging.remote.url:http://localhost:9000/api/v1/logs/addLog}")
	private String loggingServiceURL;

	private static String staticAppName;

	private static boolean staticEnableRemoteLogging;

	private static String staticLoggingServiceURL;

	public static void setStaticAppName(String name) {
		System.out.println(name);
		PropertyHolder.staticAppName = name;
	}

	public static void setStaticEnableRemoteLogging(boolean enable) {
		System.out.println(enable);
		PropertyHolder.staticEnableRemoteLogging = enable;
	}

	public static void setStaticLoggingServiceURL(String url) {
		System.out.println(url);
		PropertyHolder.staticLoggingServiceURL = url;
	}
	@PostConstruct
	private void setStaticProperties() {
		System.out.println("setting properties");
		setStaticAppName(this.appName);
		setStaticEnableRemoteLogging(this.enableRemoteLogging);
		setStaticLoggingServiceURL(this.loggingServiceURL);
	}
	public static String getApplicationName() {
		return staticAppName;
	}

	public static boolean isRemoteLoggingEnabled() {
		return staticEnableRemoteLogging;
	}

	public static String getLoggingServiceURL() {
		return staticLoggingServiceURL;
	}

}
