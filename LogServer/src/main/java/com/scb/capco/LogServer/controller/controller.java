package com.scb.capco.LogServer.controller;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.capco.LogServer.Entity.LogEntry;
import com.scb.capco.LogServer.service.FileService;

@RestController
@RequestMapping("/api/v1/logs")
public class controller {
	Logger logger = LoggerFactory.getLogger(controller.class); 

	@Autowired
	FileService service;
	
	@PostMapping
	@RequestMapping("/addTransactionLog")
	public ResponseEntity<?> addTransactionLog(@RequestBody LogEntry entry) throws Exception{
		logger.debug("Receiving transaction logging request...");
	    Date currentTime = Calendar.getInstance().getTime();	
	    try {
	      service.addTransaction(entry);
	      return new ResponseEntity<>(currentTime.getTime(), HttpStatus.ACCEPTED);
	    } catch (Exception e) {
	      logger.error("Error adding logEntry:", e);
	      throw new Exception(e);
	    }
	}
	@PostMapping
	@RequestMapping("/addApplicationLog")
	public ResponseEntity<?> addApplicationLog(@RequestBody LogEntry entry) throws Exception{
		
		logger.debug("Receiving apploication logging request...");
	    Date currentTime = Calendar.getInstance().getTime();
	    try {
	      service.addApplicationEntry(entry);
	      return new ResponseEntity<>(currentTime.getTime(), HttpStatus.ACCEPTED);
	    } catch (Exception e) {
	      logger.error("Error adding logEntry:", e);
	      throw new Exception(e);
	    }
	}
	@PostMapping
	@RequestMapping("/addAuditLog")
	public ResponseEntity<?> addAuditLog(@RequestBody LogEntry entry) throws Exception{
		logger.debug("Receiving audit slogging request...");
	    Date currentTime = Calendar.getInstance().getTime();
	    try {
	      service.addAuditEntry(entry);
	      return new ResponseEntity<>(currentTime.getTime(), HttpStatus.ACCEPTED);
	    } catch (Exception e) {
	      logger.error("Error adding logEntry:", e);
	      throw new Exception(e);
	    }
	}
	
}
