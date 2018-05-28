package com.example.LogChecker;

import com.capco.logger.SCBLogger;
import com.capco.logger.SCBLoggerFactory;

public class test2 {

	final static SCBLogger logger=SCBLoggerFactory.getApplicationLogger(test2.class);
	final static SCBLogger logger4=SCBLoggerFactory.getApplicationLogger(test2.class);
	final static SCBLogger logger2=SCBLoggerFactory.getAuditLogger(test2.class);
	final static SCBLogger logger3=SCBLoggerFactory.getTransactionLogger(test2.class);
	public void test(String data) {
		logger.info(data+"application");
		logger2.info(data+"audit");
		logger3.info(data+"transaction");
	}

}
