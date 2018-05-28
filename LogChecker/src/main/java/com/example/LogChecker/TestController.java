package com.example.LogChecker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.logger.SCBLogger;
import com.capco.logger.SCBLoggerFactory;

@RestController
public class TestController {

	final static SCBLogger logger=SCBLoggerFactory.getApplicationLogger(TestController.class);
	final static SCBLogger logger2=SCBLoggerFactory.getAuditLogger(TestController.class);
	final static SCBLogger logger3=SCBLoggerFactory.getTransactionLogger(TestController.class);
	
	@GetMapping
	@RequestMapping("/log/{data}")
	public String test(@PathVariable("data") String data) {
		logger.info(data+"application");
		logger2.info(data+"audit");
		logger3.info(data+"transaction");
		
		logger.error("error");
		Exception e=new Exception("test");
		logger.error("error2"+e);
		logger.trace("trace",e);
		test2 obj=new test2();
		obj.test("data");
		return "logged";
	}
}
