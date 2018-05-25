package com.example.LogServer.DAO;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.LogServer.Entity.LogEntry;

@Component
public class FileEntryDao implements FileEntryInterface{	 
	 private Logger logger=null;
	 

	@PostConstruct
	  private void init() {
	    System.out.println("Logging is using Files to persist log messages.");
	    initFileLogging();
	    loadLoggingCache();
	  }

	private void loadLoggingCache() {
		// TODO Auto-generated method stub
		
	}

	private void initFileLogging() {
		System.out.println("getting logger");
		this.logger = LoggerFactory.getLogger("test"); 
		
	}
	@Override
	public void save(LogEntry entry) {
		
		synchronized (logger) {
		      String msg = wrapMessage(entry);
		      logger.info(msg);
		      
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
		System.out.println(message);
		return message;
	}
}
