package com.scb.capco.LogServer.service;

import com.scb.capco.LogServer.Entity.LogEntry;

public interface FileService {

	void addApplicationEntry(LogEntry entry);

	void addAuditEntry(LogEntry entry);

	void addTransaction(LogEntry entry);

}
