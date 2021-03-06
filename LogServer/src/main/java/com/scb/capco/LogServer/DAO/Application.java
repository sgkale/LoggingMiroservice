package com.scb.capco.LogServer.DAO;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
//import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import com.scb.capco.LogServer.Entity.LogEntry;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

@Component("Application")
@PropertySource("classpath:location.properties")
public class Application implements FileEntryInterface{
	private static LoggerContext loggerContext=null;
	
	@Value("${APPLICATION_HOME:General}")
	private String applicationLocation;
	private static ConcurrentMap<String, Logger> loggerMap =new ConcurrentHashMap<String, Logger>();
	
	//private Logger logger=null;
	private Logger otpLogger=null;
	private Logger loginLogger=null;
	private Logger phoneNumberLogger=null;
	private Logger securityQuestionLogger=null;
	private Logger paymentLogger=null;
	private Logger documentsLogger=null;
	private Logger myAccountLogger=null;
	private Logger policyDashBoardLogger=null;
	private Logger pushNotificationLogger=null;
	private Logger getFNALogger=null;
	private Logger getFitLogger=null;
	private Logger activityLogger=null;
	private Logger cmsLogger=null;
	private Logger customerRegistration=null;
	private Logger generalApplication=null;


	@PostConstruct
	private void init() {
		loggerContext = (LoggerContext) LoggerFactory
				.getILoggerFactory();
		initFileLogging();
	}

	private void initFileLogging() {	
	/*	this.otpLogger=LoggerFactory.getLogger("Otp");
		this.loginLogger=LoggerFactory.getLogger("Login");
		this.phoneNumberLogger=LoggerFactory.getLogger("PhoneNumber");
		this.securityQuestionLogger=LoggerFactory.getLogger("SecurityQuestions");
		this.paymentLogger=LoggerFactory.getLogger("Payment");
		this.documentsLogger=LoggerFactory.getLogger("Documents");
		this.myAccountLogger=LoggerFactory.getLogger("MyAccount");
		this.policyDashBoardLogger=LoggerFactory.getLogger("PolicyDashboard");
		this.pushNotificationLogger=LoggerFactory.getLogger("PushNotification");
		this.getFNALogger=LoggerFactory.getLogger("GetFNA");
		this.getFitLogger=LoggerFactory.getLogger("GetFit");
		this.activityLogger=LoggerFactory.getLogger("ActivityLog");
		this.cmsLogger=LoggerFactory.getLogger("CMS");
		this.customerRegistration=LoggerFactory.getLogger("CustomerRegistration");
		this.generalApplication=LoggerFactory.getLogger("GeneralApplication");*/
	}
	private static Logger createLoggerFor(String string, String file) {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder ple = new PatternLayoutEncoder();

        ple.setPattern("%-5level %msg%n");
        ple.setContext(lc);
        ple.start();
        FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
        fileAppender.setFile(file);
        fileAppender.setEncoder(ple);
        fileAppender.setContext(lc);
        fileAppender.start();

        Logger logger = (Logger) LoggerFactory.getLogger(string);
        logger.addAppender(fileAppender);
        logger.setLevel(Level.INFO);
        logger.setAdditive(true); /* set to true if root should log too */

        return logger;
  }
	@Override
	public void save(LogEntry entry) {
		String logFileName=entry.getLogFileName();
		//logger=loggerContext.exists(logFileName);
		Logger logger=loggerMap.get(logFileName);
		if(logger==null) {
			logger=createLoggerFor(entry.getLogFileName(),applicationLocation+"/"+logFileName+".log");
			loggerMap.putIfAbsent(logFileName,logger);
		}
		/*synchronized (loggerMap.get(logFileName)) {
			logLevelWise(logger, entry);
		}*/
		logLevelWise(logger, entry);
		//		switch (entry.getLogFileName()) {
		//		case "Otp":
		//			synchronized (otpLogger) {
		//				logLevelWise(this.otpLogger, entry);
		//			}
		//			break;
		//		case "Login":
		//			synchronized (loginLogger) {
		//				logLevelWise(this.loginLogger, entry);
		//			}
		//			break;
		//		case "PhoneNumber":
		//			synchronized (phoneNumberLogger) {
		//				logLevelWise(this.phoneNumberLogger, entry);
		//			}
		//			break;
		//		case "SecurityQuestions":
		//			synchronized (securityQuestionLogger) {
		//				logLevelWise(this.securityQuestionLogger, entry);
		//			}
		//			break;
		//		case "Payment":
		//			synchronized (paymentLogger) {
		//				logLevelWise(this.paymentLogger, entry);
		//			}
		//			break;
		//		case "Documents":
		//			synchronized (documentsLogger) {
		//				logLevelWise(this.documentsLogger, entry);
		//			}
		//			break;
		//		case "PolicyDashboard":
		//			synchronized (policyDashBoardLogger) {
		//				logLevelWise(this.policyDashBoardLogger, entry);
		//			}
		//			break;
		//		case "PushNotification":
		//			synchronized (pushNotificationLogger) {
		//				logLevelWise(this.pushNotificationLogger, entry);
		//			}
		//			break;
		//		case "GetFNA":
		//			synchronized (getFNALogger) {
		//				logLevelWise(this.getFNALogger, entry);
		//			}
		//			break;
		//		case "GetFit":
		//			synchronized (getFitLogger) {
		//				logLevelWise(this.getFitLogger, entry);
		//			}
		//			break;
		//		case "ActivityLog":
		//			synchronized (activityLogger) {
		//				logLevelWise(this.activityLogger, entry);
		//			}
		//			break;
		//		case "CMS":
		//			synchronized (cmsLogger) {
		//				logLevelWise(this.cmsLogger, entry);
		//			}
		//			break;
		//		case "CustomerRegistration":
		//			synchronized (customerRegistration) {
		//				logLevelWise(this.customerRegistration, entry);
		//			}
		//			break;
		//		case "GeneralApplication":
		//			synchronized (generalApplication) {
		//				logLevelWise(this.generalApplication, entry);
		//			}
		//			break;
		//		default:
		//			synchronized (generalApplication) {
		//				logLevelWise(this.generalApplication, entry);
		//			}
		//			break;
		//		}
		//		/*synchronized (logger) {
		//			String msg = wrapMessage(entry);
		//			if(entry.getLevel()==Level.DEBUG) {
		//				logger.debug(msg);
		//			}
		//			if(entry.getLevel()==Level.ERROR) {
		//				logger.error(msg);
		//			}
		//			if(entry.getLevel()==Level.INFO) {
		//				logger.info(msg);
		//			}
		//			if(entry.getLevel()==Level.TRACE) {
		//				logger.trace(msg);
		//			}
		//		}*/
		//	
	}
	private void logLevelWise( Logger logger,LogEntry entry) {
		String msg = wrapMessage(entry);
		if(entry.getLevel()==Level.DEBUG) {
			logger.debug(msg);
		}
		if(entry.getLevel()==Level.ERROR) {
			logger.error(msg);
		}
		if(entry.getLevel()==Level.INFO) {
			logger.info(msg);
		}
		if(entry.getLevel()==Level.TRACE) {
			logger.trace(msg);
		}
	}
	private String wrapMessage(LogEntry entry) {
		String message="";
		message=message+entry.getDate();
		message=message+" ";
		message=message+entry.getOriginService();
		message=message+" ";
		message=message+entry.getMessage();
		message=message+" ";
		return message;
	}

}
