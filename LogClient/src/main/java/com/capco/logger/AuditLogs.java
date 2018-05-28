package com.capco.logger;

import java.util.Date;

import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

public class AuditLogs implements SCBLogger{
	
	private AsyncRestTemplate asyncRestClient;
	private org.slf4j.Logger slf4jLogger;
	private String className=null;
	//private String url="http://localhost:9000/api/v1/logs/addAuditLog";
	
	public AuditLogs(String name) {
		this.className=name;
		slf4jLogger = org.slf4j.LoggerFactory.getLogger(name);
		initAsync();
	}
	public boolean isRemoteLoggingEnabled() {
		return PropertyHolder.isRemoteLoggingEnabled();
	}

	public void initAsync() {
		asyncRestClient = new AsyncRestTemplate();
		asyncRestClient.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}

	public void debug(String msg, String... labels) {
		slf4jLogger.debug(msg);
		log(Level.DEBUG, msg, labels);
	}

	public void debug(String msg) {
		debug(msg, (String[]) null);
	}

	public void debug(String format, Object arg) {
		slf4jLogger.debug(format, arg);
		log(Level.DEBUG, getFormattedMessage(format, arg), (String[]) null);
	}

	public void debug(String format, Object arg1, Object arg2) {
		slf4jLogger.debug(format, arg1, arg2);
		log(Level.DEBUG, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void debug(String format, Object... arguments) {
		slf4jLogger.debug(format, arguments);
		log(Level.DEBUG, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void debug(String msg, Throwable t) {
		slf4jLogger.debug(msg, t);
		log(Level.DEBUG, msg, (String[]) null);
	}

	public void debug(Marker marker, String msg) {
		slf4jLogger.debug(marker, msg);
		log(Level.DEBUG, msg, (String[]) null);
	}

	public void debug(Marker marker, String format, Object arg) {
		slf4jLogger.debug(marker, format, arg);
		log(Level.DEBUG, getFormattedMessage(format, arg), (String[]) null);
	}

	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		slf4jLogger.debug(marker, format, arg1, arg2);
		log(Level.DEBUG, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void debug(Marker marker, String format, Object... arguments) {
		slf4jLogger.debug(marker, format, arguments);
		log(Level.DEBUG, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void debug(Marker marker, String msg, Throwable t) {
		slf4jLogger.debug(marker, msg, t);
		log(Level.DEBUG, msg, (String[]) null);
	}

	public void error(String msg, String... labels) {
		slf4jLogger.error(msg);
		log(Level.ERROR, msg, labels);
	}

	public void error(String msg) {
		error(msg, (String[]) null);
	}

	public void error(String format, Object arg) {
		slf4jLogger.error(format, arg);
		log(Level.ERROR, getFormattedMessage(format, arg), (String[]) null);
	}

	public void error(String format, Object arg1, Object arg2) {
		slf4jLogger.error(format, arg1, arg2);
		log(Level.ERROR, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void error(String format, Object... arguments) {
		slf4jLogger.error(format, arguments);
		log(Level.ERROR, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void error(String msg, Throwable t) {
		slf4jLogger.error(msg, t);
		log(Level.ERROR, msg, (String[]) null);
	}

	public void error(Marker marker, String msg) {
		slf4jLogger.error(marker, msg);
		log(Level.ERROR, msg, (String[]) null);
	}

	public void error(Marker marker, String format, Object arg) {
		slf4jLogger.error(marker, format, arg);
		log(Level.ERROR, getFormattedMessage(format, arg), (String[]) null);
	}

	public void error(Marker marker, String format, Object arg1, Object arg2) {
		slf4jLogger.error(marker, format, arg1, arg2);
		log(Level.ERROR, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void error(Marker marker, String format, Object... arguments) {
		slf4jLogger.error(marker, format, arguments);
		log(Level.ERROR, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void error(Marker marker, String msg, Throwable t) {
		slf4jLogger.error(marker, msg, t);
		log(Level.ERROR, msg, (String[]) null);
	}

	public void trace(String msg, String... labels) {
		slf4jLogger.trace(msg);
		log(Level.TRACE, msg, labels);
	}

	public void trace(String msg) {
		trace(msg, (String[]) null);
	}

	public void trace(String format, Object arg) {
		slf4jLogger.trace(format, arg);
		log(Level.TRACE, getFormattedMessage(format, arg), (String[]) null);
	}

	public void trace(String format, Object arg1, Object arg2) {
		slf4jLogger.trace(format, arg1, arg2);
		log(Level.TRACE, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void trace(String format, Object... arguments) {
		slf4jLogger.trace(format, arguments);
		log(Level.TRACE, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void trace(String msg, Throwable t) {
		slf4jLogger.trace(msg, t);
		log(Level.TRACE, msg, (String[]) null);
	}

	public void trace(Marker marker, String msg) {
		slf4jLogger.trace(marker, msg);
		log(Level.TRACE, msg, (String[]) null);
	}

	public void trace(Marker marker, String format, Object arg) {
		slf4jLogger.trace(marker, format, arg);
		log(Level.TRACE, getFormattedMessage(format, arg), (String[]) null);
	}

	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		slf4jLogger.trace(marker, format, arg1, arg2);
		log(Level.TRACE, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void trace(Marker marker, String format, Object... arguments) {
		slf4jLogger.trace(marker, format, arguments);
		log(Level.TRACE, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void trace(Marker marker, String msg, Throwable t) {
		slf4jLogger.trace(marker, msg, t);
		log(Level.TRACE, msg, (String[]) null);
	}

	public void info(String msg, String... labels) {
		slf4jLogger.info(msg);
		log(Level.INFO, msg, labels);
	}

	public void info(String msg) {
		info(msg, (String[]) null);
	}

	public void info(String format, Object arg) {
		slf4jLogger.info(format, arg);
		log(Level.INFO, getFormattedMessage(format, arg), (String[]) null);
	}

	public void info(String format, Object arg1, Object arg2) {
		slf4jLogger.info(format, arg1, arg2);
		log(Level.INFO, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void info(String format, Object... arguments) {
		slf4jLogger.info(format, arguments);
		log(Level.INFO, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void info(String msg, Throwable t) {
		slf4jLogger.info(msg, t);
		log(Level.INFO, msg, (String[]) null);
	}

	public void info(Marker marker, String msg) {
		slf4jLogger.info(marker, msg);
		log(Level.INFO, msg, (String[]) null);
	}

	public void info(Marker marker, String format, Object arg) {
		slf4jLogger.info(marker, format, arg);
		log(Level.INFO, getFormattedMessage(format, arg), (String[]) null);
	}

	public void info(Marker marker, String format, Object arg1, Object arg2) {
		slf4jLogger.info(marker, format, arg1, arg2);
		log(Level.INFO, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void info(Marker marker, String format, Object... arguments) {
		slf4jLogger.info(marker, format, arguments);
		log(Level.INFO, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void info(Marker marker, String msg, Throwable t) {
		slf4jLogger.info(marker, msg, t);
		log(Level.INFO, msg, (String[]) null);
	}

	public void warn(String msg, String... labels) {
		slf4jLogger.warn(msg);
		log(Level.WARN, msg, labels);
	}

	public void warn(String msg) {
		warn(msg, (String[]) null);
	}

	public void warn(String format, Object arg) {
		slf4jLogger.warn(format, arg);
		log(Level.WARN, getFormattedMessage(format, arg), (String[]) null);
	}

	public void warn(String format, Object... arguments) {
		slf4jLogger.warn(format, arguments);
		log(Level.WARN, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void warn(String format, Object arg1, Object arg2) {
		slf4jLogger.warn(format, arg1, arg2);
		log(Level.WARN, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void warn(String msg, Throwable t) {
		slf4jLogger.warn(msg, t);
		log(Level.WARN, msg, (String[]) null);
	}

	public void warn(Marker marker, String msg) {
		slf4jLogger.warn(marker, msg);
		log(Level.WARN, msg, (String[]) null);
	}

	public void warn(Marker marker, String format, Object arg) {
		slf4jLogger.warn(marker, format, arg);
		log(Level.WARN, getFormattedMessage(format, arg), (String[]) null);
	}

	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		slf4jLogger.warn(marker, format, arg1, arg2);
		log(Level.WARN, getFormattedMessage(format, arg1, arg2), (String[]) null);
	}

	public void warn(Marker marker, String format, Object... arguments) {
		slf4jLogger.warn(marker, format, arguments);
		log(Level.WARN, getFormattedMessage(format, arguments), (String[]) null);
	}

	public void warn(Marker marker, String msg, Throwable t) {
		slf4jLogger.warn(marker, msg, t);
		log(Level.WARN, msg, (String[]) null);
	}

	public String getName() {
		return slf4jLogger.getName();
	}
	public void log(Level logLevel, String msg, String... labels) {
		if(isRemoteLoggingEnabled()==true) {
			LogEntry logEntry = buildLogEntry(logLevel, msg, labels);
			invokeAsyncRestLogging(logEntry);
		}

	}
	public void invokeAsyncRestLogging(LogEntry logEntry) {
		
		HttpEntity<LogEntry> entity = new HttpEntity<LogEntry>(logEntry);
		ListenableFuture<ResponseEntity<Long>> futureEntity = asyncRestClient
				.postForEntity(PropertyHolder.getStaticAuditUrl(), entity, Long.class);
		// register a callback for asynchronous invocation
		futureEntity.addCallback(new ListenableFutureCallback<ResponseEntity<Long>>() {
			public void onSuccess(ResponseEntity<Long> result) {// callback for success
				System.out.println("Result from remote logging service: " + result);

			}

			public void onFailure(Throwable ex) {// callback for failure
				System.out.println("Error invoking remote logging service: " + ex);
			}
		});
	}
	public com.capco.logger.LogEntry buildLogEntry(Level logLevel, String msg, String... labels) {
		LogEntry entry=new LogEntry();
		entry.setDate(new Date());
		entry.setMessage(this.className+" "+msg);
		entry.setOriginService(getOriginServiceName());		
		return entry;
	}
	public String getOriginServiceName() {		
		return PropertyHolder.getApplicationName();
	}
	public String getFormattedMessage(String format, Object arg) {
		FormattingTuple ft = MessageFormatter.format(format, arg);
		return ft.getMessage();
	}
	public String getFormattedMessage(String format, Object arg1, Object arg2) {
		FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
		return ft.getMessage();
	}

	public String getFormattedMessage(String format, Object... arguments) {
		FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
		return ft.getMessage();
	}



}
