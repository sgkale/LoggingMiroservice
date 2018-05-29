package com.scb.capco.LogServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LogServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LogServerApplication.class, args);
		ConfigurableApplicationContext ctx =
				SpringApplication.run(LogServerApplication.class, args);
		String welcomeMsg = ctx.getEnvironment().getProperty("app.open.msg");
	}
}
