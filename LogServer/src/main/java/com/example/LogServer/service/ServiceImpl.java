package com.example.LogServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.LogServer.DAO.FileEntryInterface;
import com.example.LogServer.Entity.LogEntry;

@Service
public class ServiceImpl implements FileService{

	@Autowired
	FileEntryInterface fileInterface;
	
	@Override
	@Async
	public void addLogEntry(LogEntry entry) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fileInterface.save(entry);
	}
}
