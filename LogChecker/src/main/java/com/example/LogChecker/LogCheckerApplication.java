package com.example.LogChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.capco.logger","com.example"})
public class LogCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogCheckerApplication.class, args);
	}
}
