package com.example.LogChecker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.logger.SCBLogger;
import com.capco.logger.SCBLoggerFactory;

@RestController
public class TestController {

	final static SCBLogger logger=SCBLoggerFactory.getSCBLogger(TestController.class);
	
	@GetMapping
	@RequestMapping("/log/{data}")
	public String test(@PathVariable("data") String data) {
		logger.info(data);
		return "logged";
	}
}
