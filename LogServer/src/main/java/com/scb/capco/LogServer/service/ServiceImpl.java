package com.scb.capco.LogServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.scb.capco.LogServer.DAO.FileEntryInterface;
import com.scb.capco.LogServer.Entity.LogEntry;

@Service
public class ServiceImpl implements FileService{

	@Autowired
	@Qualifier("Application")
	FileEntryInterface applicationFile;
	@Autowired
	@Qualifier("Audit")
	FileEntryInterface auditFile;
	@Autowired
	@Qualifier("Transaction")
	FileEntryInterface transactionFile;
	
	@Override
	@Async
	public void addApplicationEntry(LogEntry entry) {
		applicationFile.save(entry);
	}
	@Override
	@Async
	public void addAuditEntry(LogEntry entry) {
		auditFile.save(entry);
	}
	@Override
	@Async
	public void addTransaction(LogEntry entry) {
		transactionFile.save(entry);
	}
}
