package com.capco.logger;

import org.slf4j.Marker;
import org.slf4j.event.Level;

public interface SCBLogger {

	String getFormattedMessage(String format, Object... arguments);

	String getFormattedMessage(String format, Object arg1, Object arg2);

	String getFormattedMessage(String format, Object arg);

	String getOriginServiceName();

	com.capco.logger.LogEntry buildLogEntry(Level logLevel, String msg, String... labels);

	void invokeAsyncRestLogging(LogEntry logEntry);

	void log(Level logLevel, String msg, String... labels);

	String getName();

	void warn(Marker marker, String msg, Throwable t);

	void warn(Marker marker, String format, Object... arguments);

	void warn(Marker marker, String format, Object arg1, Object arg2);

	void warn(Marker marker, String format, Object arg);

	void warn(Marker marker, String msg);

	void warn(String msg, Throwable t);

	void warn(String format, Object arg1, Object arg2);

	void warn(String format, Object... arguments);

	void warn(String format, Object arg);

	void warn(String msg);

	void warn(String msg, String... labels);

	void info(Marker marker, String msg, Throwable t);

	void info(Marker marker, String format, Object... arguments);

	void info(Marker marker, String format, Object arg1, Object arg2);

	void info(Marker marker, String format, Object arg);

	void info(Marker marker, String msg);

	void info(String msg, Throwable t);

	void info(String format, Object... arguments);

	void info(String format, Object arg1, Object arg2);

	void info(String format, Object arg);

	void info(String msg);

	void info(String msg, String... labels);

	void trace(Marker marker, String msg, Throwable t);

	void trace(Marker marker, String format, Object... arguments);

	void trace(Marker marker, String format, Object arg1, Object arg2);

	void trace(Marker marker, String format, Object arg);

	void trace(Marker marker, String msg);

	void trace(String msg, Throwable t);

	void trace(String format, Object... arguments);

	void trace(String format, Object arg1, Object arg2);

	void trace(String format, Object arg);

	void trace(String msg);

	void trace(String msg, String... labels);

	void error(Marker marker, String msg, Throwable t);

	void error(Marker marker, String format, Object... arguments);

	void error(Marker marker, String format, Object arg1, Object arg2);

	void error(Marker marker, String format, Object arg);

	void error(Marker marker, String msg);

	void error(String msg, Throwable t);

	void error(String format, Object... arguments);

	void error(String format, Object arg1, Object arg2);

	void error(String format, Object arg);

	void error(String msg);

	void error(String msg, String... labels);

	void debug(Marker marker, String msg, Throwable t);

	void debug(Marker marker, String format, Object... arguments);

	void debug(Marker marker, String format, Object arg1, Object arg2);

	void debug(Marker marker, String format, Object arg);

	void debug(Marker marker, String msg);

	void debug(String msg, Throwable t);

	void debug(String format, Object... arguments);

	void debug(String format, Object arg1, Object arg2);

	void debug(String format, Object arg);

	void debug(String msg);

	void debug(String msg, String... labels);

	void initAsync();

	//boolean isRemoteLoggingEnabled();



}
