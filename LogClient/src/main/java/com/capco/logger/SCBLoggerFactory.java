package com.capco.logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class SCBLoggerFactory {
	//used so that same class can have three different types of logger - application/audit/transaction
	private final static String applicationAppender="Application-";
	private final static String auditAppender="Audit-";
	private final static String transactionAppender="Transaction-";

	private SCBLoggerFactory() {}

	private static ConcurrentMap<String, SCBLogger> loggerMap =new ConcurrentHashMap<String, SCBLogger>();

	public static SCBLogger getTransactionLogger(String name) {

		SCBLogger logger=loggerMap.get(transactionAppender+""+name);
		if(logger!=null) {
			return logger;
		}
		else {
			SCBLogger newInstance=new TransactionLogs(transactionAppender+""+name);
			SCBLogger oldInstance=loggerMap.putIfAbsent(transactionAppender+""+name, newInstance);
			return oldInstance==null?newInstance:oldInstance;
		}
	}
	public static SCBLogger getTransactionLogger(Class<?> clazz) {
		return getTransactionLogger(clazz.getName());
	}
	
	
	public static SCBLogger getAuditLogger(String name) {
		SCBLogger logger=loggerMap.get(auditAppender+""+name);
		if(logger!=null) {
			return logger;
		}
		else {
			SCBLogger newInstance=new AuditLogs(auditAppender+""+name);
			SCBLogger oldInstance=loggerMap.putIfAbsent(auditAppender+""+name, newInstance);
			return oldInstance==null?newInstance:oldInstance;
		}
	}
	public static SCBLogger getAuditLogger(Class<?> clazz) {
		return getAuditLogger(clazz.getName());
	}
	public static SCBLogger getApplicationLogger(String name) {
		SCBLogger logger=loggerMap.get(applicationAppender+""+name);
		if(logger!=null) {
			return logger;
		}
		else {
			SCBLogger newInstance=new ApplicationLogs(applicationAppender+""+name);
			SCBLogger oldInstance=loggerMap.putIfAbsent(applicationAppender+""+name, newInstance);
			return oldInstance==null?newInstance:oldInstance;
		}
	}
	public static SCBLogger getApplicationLogger(Class<?> clazz) {
		return getApplicationLogger(clazz.getName());
	}
	

}
