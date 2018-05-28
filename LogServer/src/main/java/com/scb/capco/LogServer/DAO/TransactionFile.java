package com.scb.capco.LogServer.DAO;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.scb.capco.LogServer.Entity.LogEntry;

@Component("Transaction")
public class TransactionFile implements FileEntryInterface{	 
	private Logger logger=null;


	@PostConstruct
	private void init() {
		initFileLogging();
	}

	private void initFileLogging() {
		this.logger = LoggerFactory.getLogger("Transaction");		
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
		return message;
	}
}
