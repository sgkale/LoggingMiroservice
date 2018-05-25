package com.example.LogServer.controller;

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

import com.example.LogServer.Entity.LogEntry;
import com.example.LogServer.service.FileService;

@RestController
@RequestMapping("/api/v1/logs")
public class controller {
	Logger logger = LoggerFactory.getLogger(controller.class); 

	@Autowired
	FileService service;
	
	@PostMapping
	@RequestMapping("/addLog")
	public ResponseEntity<?> addLogEntry(@RequestBody LogEntry entry) throws Exception{
		logger.debug("Receiving logging request...");
		System.out.println("logged");
	    Date currentTime = Calendar.getInstance().getTime();	  
	    //entry.setDate(currentTime);
	    try {
	      service.addLogEntry(entry);
	      return new ResponseEntity<>(currentTime.getTime(), HttpStatus.ACCEPTED);
	    } catch (Exception e) {
	      logger.error("Error adding logEntry:", e);
	      throw new Exception(e);
	    }
	}
	
}
