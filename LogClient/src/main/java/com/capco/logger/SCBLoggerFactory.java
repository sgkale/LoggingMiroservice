package com.capco.logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class SCBLoggerFactory {

	private SCBLoggerFactory() {}

	private static ConcurrentMap<String, SCBLogger> loggerMap =new ConcurrentHashMap<String, SCBLogger>();

	public static SCBLogger getSCBLogger(String name) {
		//loggerMap= new ConcurrentHashMap<String, SCBLogger>();
		System.out.println("get logger method"+name);
		SCBLogger logger=loggerMap.get(name);
		if(logger!=null) {
			return logger;
		}
		else {
			SCBLogger newInstance=new SCBLogger(name);
			//loggerMap.put(key, value)
			SCBLogger oldInstance=loggerMap.putIfAbsent(name, newInstance);
			return oldInstance==null?newInstance:oldInstance;
			//return newInstance
		}
	}
	public static SCBLogger getSCBLogger(Class<?> clazz) {
		System.out.println("getting logger");
		return getSCBLogger(clazz.getName());
	}

}
